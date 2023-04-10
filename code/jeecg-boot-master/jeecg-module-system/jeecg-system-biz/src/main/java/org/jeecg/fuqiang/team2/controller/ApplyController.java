package org.jeecg.fuqiang.team2.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.fuqiang.team2.service.IApplyService;
import org.jeecg.fuqiang.team2.entity.Apply;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 申请表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Api(tags="申请表")
@RestController
@RequestMapping("/fq/apply")
@Slf4j
public class ApplyController extends JeecgController<Apply, IApplyService> {
	@Autowired
	private IApplyService applyService;
	
	/**
	 * 分页列表查询
	 *
	 * @param apply
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "申请表-分页列表查询")
	@ApiOperation(value="申请表-分页列表查询", notes="申请表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Apply>> queryPageList(Apply apply,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Apply> queryWrapper = QueryGenerator.initQueryWrapper(apply, req.getParameterMap());
		Page<Apply> page = new Page<Apply>(pageNo, pageSize);
		IPage<Apply> pageList = applyService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param apply
	 * @return
	 */
	@AutoLog(value = "申请表-添加")
	@ApiOperation(value="申请表-添加", notes="申请表-添加")
	//@RequiresPermissions("org.jeecg.modules:fq_apply:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Apply apply) {
		applyService.save(apply);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param apply
	 * @return
	 */
	@AutoLog(value = "申请表-编辑")
	@ApiOperation(value="申请表-编辑", notes="申请表-编辑")
	//@RequiresPermissions("org.jeecg.modules:fq_apply:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Apply apply) {
		applyService.updateById(apply);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "申请表-通过id删除")
	@ApiOperation(value="申请表-通过id删除", notes="申请表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:fq_apply:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		applyService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "申请表-批量删除")
	@ApiOperation(value="申请表-批量删除", notes="申请表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:fq_apply:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.applyService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "申请表-通过id查询")
	@ApiOperation(value="申请表-通过id查询", notes="申请表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Apply> queryById(@RequestParam(name="id",required=true) String id) {
		Apply apply = applyService.getById(id);
		if(apply==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(apply);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param apply
    */
    //@RequiresPermissions("org.jeecg.modules:fq_apply:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Apply apply) {
        return super.exportXls(request, apply, Apply.class, "申请表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("fq_apply:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Apply.class);
    }

}
