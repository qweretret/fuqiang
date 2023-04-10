package org.jeecg.modules.iternshipProgram.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.iternshipProgram.entity.JobDept;
import org.jeecg.modules.iternshipProgram.service.IJobDeptService;

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
 * @Description: 系级表
 * @Author: jeecg-boot
 * @Date:   2022-09-15
 * @Version: V1.0
 */
@Api(tags="系级表")
@RestController
@RequestMapping("/dept/jobDept")
@Slf4j
public class JobDeptController extends JeecgController<JobDept, IJobDeptService> {
	@Autowired
	private IJobDeptService jobDeptService;
	
	/**
	 * 分页列表查询
	 *
	 * @param jobDept
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "系级表-分页列表查询")
	@ApiOperation(value="系级表-分页列表查询", notes="系级表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<JobDept>> queryPageList(JobDept jobDept,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<JobDept> queryWrapper = QueryGenerator.initQueryWrapper(jobDept, req.getParameterMap());
		Page<JobDept> page = new Page<JobDept>(pageNo, pageSize);
		IPage<JobDept> pageList = jobDeptService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	 /**
	  *  列表查询
	  *
	  * @return 列表
	  */
	 @GetMapping(value = "/lists")
	 public Result<List<JobDept>> queryall() {
		 Result<List<JobDept>> result = new Result<>();
		 List<JobDept> list = jobDeptService.list();
		 if(list==null||list.size()<=0) {
			 result.error500("未找到系级信息");
		 }else {
			 result.setResult(list);
			 result.setSuccess(true);
		 }
		 return result;
	 }

	/**
	 *   添加
	 *
	 * @param jobDept
	 * @return
	 */
	@AutoLog(value = "系级表-添加")
	@ApiOperation(value="系级表-添加", notes="系级表-添加")
	//@RequiresPermissions("org.jeecg.modules:job_dept:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody JobDept jobDept) {
		jobDeptService.save(jobDept);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jobDept
	 * @return
	 */
	@AutoLog(value = "系级表-编辑")
	@ApiOperation(value="系级表-编辑", notes="系级表-编辑")
	//@RequiresPermissions("org.jeecg.modules:job_dept:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody JobDept jobDept) {
		jobDeptService.updateById(jobDept);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "系级表-通过id删除")
	@ApiOperation(value="系级表-通过id删除", notes="系级表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:job_dept:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		jobDeptService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "系级表-批量删除")
	@ApiOperation(value="系级表-批量删除", notes="系级表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:job_dept:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.jobDeptService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "系级表-通过id查询")
	@ApiOperation(value="系级表-通过id查询", notes="系级表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<JobDept> queryById(@RequestParam(name="id",required=true) String id) {
		JobDept jobDept = jobDeptService.getById(id);
		if(jobDept==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(jobDept);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jobDept
    */
    //@RequiresPermissions("org.jeecg.modules:job_dept:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, JobDept jobDept) {
        return super.exportXls(request, jobDept, JobDept.class, "系级表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("job_dept:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, JobDept.class);
    }

}
