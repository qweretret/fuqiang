package org.jeecg.modules.iternshipProgram.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.iternshipProgram.entity.JobCase;
import org.jeecg.modules.iternshipProgram.service.IJobCaseService;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 实习方案表
 * @Author: jeecg-boot
 * @Date:   2022-09-15
 * @Version: V1.0
 */
@Api(tags="实习方案表")
@RestController
@RequestMapping("/jobCase/jobCase")
@Slf4j
public class JobCaseController extends JeecgController<JobCase, IJobCaseService> {
	@Autowired
	private IJobCaseService jobCaseService;

	/**
	 * 分页列表查询
	 *
	 * @param jobCase
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "实习方案表-分页列表查询")
	@ApiOperation(value="实习方案表-分页列表查询", notes="实习方案表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<JobCase>> queryPageList(JobCase jobCase,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<JobCase> queryWrapper = QueryGenerator.initQueryWrapper(jobCase, req.getParameterMap());
		Page<JobCase> page = new Page<JobCase>(pageNo, pageSize);
		queryWrapper.eq("b.available","1");
		IPage<JobCase> pageList = jobCaseService.list(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param jobCase
	 * @return
	 */
	@AutoLog(value = "实习方案表-添加")
	@ApiOperation(value="实习方案表-添加", notes="实习方案表-添加")
	//@RequiresPermissions("org.jeecg.modules:job_case:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody JobCase jobCase) {
		jobCaseService.save(jobCase);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jobCase
	 * @return
	 */
	@AutoLog(value = "实习方案表-编辑")
	@ApiOperation(value="实习方案表-编辑", notes="实习方案表-编辑")
	//@RequiresPermissions("org.jeecg.modules:job_case:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody JobCase jobCase) {
		jobCaseService.updateById(jobCase);
		return Result.OK("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "实习方案表-通过id删除")
	@ApiOperation(value="实习方案表-通过id删除", notes="实习方案表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:job_case:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		jobCaseService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "实习方案表-批量删除")
	@ApiOperation(value="实习方案表-批量删除", notes="实习方案表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:job_case:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.jobCaseService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "实习方案表-通过id查询")
	@ApiOperation(value="实习方案表-通过id查询", notes="实习方案表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<JobCase> queryById(@RequestParam(name="id",required=true) String id) {
		JobCase jobCase = jobCaseService.getById(id);
		if(jobCase==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(jobCase);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jobCase
    */
    //@RequiresPermissions("org.jeecg.modules:job_case:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, JobCase jobCase) {
        return super.exportXls(request, jobCase, JobCase.class, "实习方案表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("job_case:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, JobCase.class);
    }

}
