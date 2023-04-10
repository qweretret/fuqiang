package org.jeecg.fuqiang.team3.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.jeecg.common.exception.JeecgBootException;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.common.system.vo.SelectTreeModel;
import org.jeecg.fuqiang.team3.entity.StuffType;
import org.jeecg.fuqiang.team3.mapper.StuffTypeMapper;
import org.jeecg.fuqiang.team3.service.IStuffTypeService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 材料表
 * @Author: jeecg-boot
 * @Date:   2022-12-05
 * @Version: V1.0
 */
@Service
public class StuffTypeServiceImpl extends ServiceImpl<StuffTypeMapper, StuffType> implements IStuffTypeService {

	@Override
	public void addStuffType(StuffType stuffType) {
	   //新增时设置hasChild为0
	    stuffType.setHasChild(IStuffTypeService.NOCHILD);
		if(oConvertUtils.isEmpty(stuffType.getPid())){
			stuffType.setPid(IStuffTypeService.ROOT_PID_VALUE);
		}else{
			//如果当前节点父ID不为空 则设置父节点的hasChildren 为1
			StuffType parent = baseMapper.selectById(stuffType.getPid());
			if(parent!=null && !"1".equals(parent.getHasChild())){
				parent.setHasChild("1");
				baseMapper.updateById(parent);
			}
		}
		baseMapper.insert(stuffType);
	}
	
	@Override
	public void updateStuffType(StuffType stuffType) {
		StuffType entity = this.getById(stuffType.getId());
		if(entity==null) {
			throw new JeecgBootException("未找到对应实体");
		}
		String old_pid = entity.getPid();
		String new_pid = stuffType.getPid();
		if(!old_pid.equals(new_pid)) {
			updateOldParentNode(old_pid);
			if(oConvertUtils.isEmpty(new_pid)){
				stuffType.setPid(IStuffTypeService.ROOT_PID_VALUE);
			}
			if(!IStuffTypeService.ROOT_PID_VALUE.equals(stuffType.getPid())) {
				baseMapper.updateTreeNodeStatus(stuffType.getPid(), IStuffTypeService.HASCHILD);
			}
		}
		baseMapper.updateById(stuffType);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteStuffType(String id) throws JeecgBootException {
		//查询选中节点下所有子节点一并删除
        id = this.queryTreeChildIds(id);
        if(id.indexOf(",")>0) {
            StringBuffer sb = new StringBuffer();
            String[] idArr = id.split(",");
            for (String idVal : idArr) {
                if(idVal != null){
                    StuffType stuffType = this.getById(idVal);
                    String pidVal = stuffType.getPid();
                    //查询此节点上一级是否还有其他子节点
                    List<StuffType> dataList = baseMapper.selectList(new QueryWrapper<StuffType>().eq("pid", pidVal).notIn("id",Arrays.asList(idArr)));
                    boolean flag = (dataList == null || dataList.size() == 0) && !Arrays.asList(idArr).contains(pidVal) && !sb.toString().contains(pidVal);
                    if(flag){
                        //如果当前节点原本有子节点 现在木有了，更新状态
                        sb.append(pidVal).append(",");
                    }
                }
            }
            //批量删除节点
            baseMapper.deleteBatchIds(Arrays.asList(idArr));
            //修改已无子节点的标识
            String[] pidArr = sb.toString().split(",");
            for(String pid : pidArr){
                this.updateOldParentNode(pid);
            }
        }else{
            StuffType stuffType = this.getById(id);
            if(stuffType==null) {
                throw new JeecgBootException("未找到对应实体");
            }
            updateOldParentNode(stuffType.getPid());
            baseMapper.deleteById(id);
        }
	}
	
	@Override
    public List<StuffType> queryTreeListNoPage(QueryWrapper<StuffType> queryWrapper) {
        List<StuffType> dataList = baseMapper.selectList(queryWrapper);
        List<StuffType> mapList = new ArrayList<>();
        for(StuffType data : dataList){
            String pidVal = data.getPid();
            //递归查询子节点的根节点
            if(pidVal != null && !IStuffTypeService.NOCHILD.equals(pidVal)){
                StuffType rootVal = this.getTreeRoot(pidVal);
                if(rootVal != null && !mapList.contains(rootVal)){
                    mapList.add(rootVal);
                }
            }else{
                if(!mapList.contains(data)){
                    mapList.add(data);
                }
            }
        }
        return mapList;
    }

    @Override
    public List<SelectTreeModel> queryListByCode(String parentCode) {
        String pid = ROOT_PID_VALUE;
        if (oConvertUtils.isNotEmpty(parentCode)) {
            LambdaQueryWrapper<StuffType> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(StuffType::getPid, parentCode);
            List<StuffType> list = baseMapper.selectList(queryWrapper);
            if (list == null || list.size() == 0) {
                throw new JeecgBootException("该编码【" + parentCode + "】不存在，请核实!");
            }
            if (list.size() > 1) {
                throw new JeecgBootException("该编码【" + parentCode + "】存在多个，请核实!");
            }
            pid = list.get(0).getId();
        }
        return baseMapper.queryListByPid(pid, null);
    }

    @Override
    public List<SelectTreeModel> queryListByPid(String pid) {
        if (oConvertUtils.isEmpty(pid)) {
            pid = ROOT_PID_VALUE;
        }
        return baseMapper.queryListByPid(pid, null);
    }

	/**
	 * 根据所传pid查询旧的父级节点的子节点并修改相应状态值
	 * @param pid
	 */
	private void updateOldParentNode(String pid) {
		if(!IStuffTypeService.ROOT_PID_VALUE.equals(pid)) {
			Long count = baseMapper.selectCount(new QueryWrapper<StuffType>().eq("pid", pid));
			if(count==null || count<=1) {
				baseMapper.updateTreeNodeStatus(pid, IStuffTypeService.NOCHILD);
			}
		}
	}

	/**
     * 递归查询节点的根节点
     * @param pidVal
     * @return
     */
    private StuffType getTreeRoot(String pidVal){
        StuffType data =  baseMapper.selectById(pidVal);
        if(data != null && !IStuffTypeService.ROOT_PID_VALUE.equals(data.getPid())){
            return this.getTreeRoot(data.getPid());
        }else{
            return data;
        }
    }

    /**
     * 根据id查询所有子节点id
     * @param ids
     * @return
     */
    private String queryTreeChildIds(String ids) {
        //获取id数组
        String[] idArr = ids.split(",");
        StringBuffer sb = new StringBuffer();
        for (String pidVal : idArr) {
            if(pidVal != null){
                if(!sb.toString().contains(pidVal)){
                    if(sb.toString().length() > 0){
                        sb.append(",");
                    }
                    sb.append(pidVal);
                    this.getTreeChildIds(pidVal,sb);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 递归查询所有子节点
     * @param pidVal
     * @param sb
     * @return
     */
    private StringBuffer getTreeChildIds(String pidVal,StringBuffer sb){
        List<StuffType> dataList = baseMapper.selectList(new QueryWrapper<StuffType>().eq("pid", pidVal));
        if(dataList != null && dataList.size()>0){
            for(StuffType tree : dataList) {
                if(!sb.toString().contains(tree.getId())){
                    sb.append(",").append(tree.getId());
                }
                this.getTreeChildIds(tree.getId(),sb);
            }
        }
        return sb;
    }

}
