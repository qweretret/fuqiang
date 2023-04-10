package org.jeecg.fuqiang.team3.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.fuqiang.team3.entity.WorkPlan;
import org.jeecg.fuqiang.team3.service.IWorkPlanService;

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
 * @Description: 月度计划及完成情况
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Api(tags="月度计划及完成情况")
@RestController
@RequestMapping("/fq/workPlan")
@Slf4j
public class WorkPlanController extends JeecgController<WorkPlan, IWorkPlanService> {
	@Autowired
	private IWorkPlanService workPlanService;
	
	/**
	 * 分页列表查询
	 *
	 * @param workPlan
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "月度计划及完成情况-分页列表查询")
	@ApiOperation(value="月度计划及完成情况-分页列表查询", notes="月度计划及完成情况-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<WorkPlan>> queryPageList(WorkPlan workPlan,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<WorkPlan> queryWrapper = QueryGenerator.initQueryWrapper(workPlan, req.getParameterMap());
		Page<WorkPlan> page = new Page<WorkPlan>(pageNo, pageSize);
		IPage<WorkPlan> pageList = workPlanService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param workPlan
	 * @return
	 */
	@AutoLog(value = "月度计划及完成情况-添加")
	@ApiOperation(value="月度计划及完成情况-添加", notes="月度计划及完成情况-添加")
	//@RequiresPermissions("org.jeecg.modules:fq_work_plan:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody WorkPlan workPlan) {
		workPlanService.save(workPlan);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param workPlan
	 * @return
	 */
	@AutoLog(value = "月度计划及完成情况-编辑")
	@ApiOperation(value="月度计划及完成情况-编辑", notes="月度计划及完成情况-编辑")
	//@RequiresPermissions("org.jeecg.modules:fq_work_plan:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody WorkPlan workPlan) {
		workPlanService.updateById(workPlan);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "月度计划及完成情况-通过id删除")
	@ApiOperation(value="月度计划及完成情况-通过id删除", notes="月度计划及完成情况-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:fq_work_plan:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		workPlanService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "月度计划及完成情况-批量删除")
	@ApiOperation(value="月度计划及完成情况-批量删除", notes="月度计划及完成情况-批量删除")
	//@RequiresPermissions("org.jeecg.modules:fq_work_plan:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.workPlanService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "月度计划及完成情况-通过id查询")
	@ApiOperation(value="月度计划及完成情况-通过id查询", notes="月度计划及完成情况-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<WorkPlan> queryById(@RequestParam(name="id",required=true) String id) {
		WorkPlan workPlan = workPlanService.getById(id);
		if(workPlan==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(workPlan);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param workPlan
    */
    //@RequiresPermissions("org.jeecg.modules:fq_work_plan:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, WorkPlan workPlan) {
        return super.exportXls(request, workPlan, WorkPlan.class, "月度计划及完成情况");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("fq_work_plan:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, WorkPlan.class);
    }

}
