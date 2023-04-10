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

import org.jeecg.modules.iternshipProgram.entity.JobPracticecmp;
import org.jeecg.modules.iternshipProgram.service.IJobPracticecmpService;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 实习企业表
 * @Author: jeecg-boot
 * @Date:   2022-09-15
 * @Version: V1.0
 */
@Api(tags="实习企业表")
@RestController
@RequestMapping("/JobPracticecmp/jobPracticecmp")
@Slf4j
public class JobPracticecmpController extends JeecgController<JobPracticecmp, IJobPracticecmpService> {
	@Autowired
	private IJobPracticecmpService jobPracticecmpService;
	
	/**
	 * 分页列表查询
	 *
	 * @param jobPracticecmp
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "实习企业表-分页列表查询")
	@ApiOperation(value="实习企业表-分页列表查询", notes="实习企业表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<JobPracticecmp>> queryPageList(JobPracticecmp jobPracticecmp,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<JobPracticecmp> queryWrapper = QueryGenerator.initQueryWrapper(jobPracticecmp, req.getParameterMap());
		Page<JobPracticecmp> page = new Page<JobPracticecmp>(pageNo, pageSize);
		IPage<JobPracticecmp> pageList = jobPracticecmpService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param jobPracticecmp
	 * @return
	 */
	@AutoLog(value = "实习企业表-添加")
	@ApiOperation(value="实习企业表-添加", notes="实习企业表-添加")
	//@RequiresPermissions("org.jeecg.modules:job_practicecmp:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody JobPracticecmp jobPracticecmp) {
		jobPracticecmpService.save(jobPracticecmp);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jobPracticecmp
	 * @return
	 */
	@AutoLog(value = "实习企业表-编辑")
	@ApiOperation(value="实习企业表-编辑", notes="实习企业表-编辑")
	//@RequiresPermissions("org.jeecg.modules:job_practicecmp:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody JobPracticecmp jobPracticecmp) {
		jobPracticecmpService.updateById(jobPracticecmp);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "实习企业表-通过id删除")
	@ApiOperation(value="实习企业表-通过id删除", notes="实习企业表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:job_practicecmp:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		jobPracticecmpService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "实习企业表-批量删除")
	@ApiOperation(value="实习企业表-批量删除", notes="实习企业表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:job_practicecmp:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.jobPracticecmpService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "实习企业表-通过id查询")
	@ApiOperation(value="实习企业表-通过id查询", notes="实习企业表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<JobPracticecmp> queryById(@RequestParam(name="id",required=true) String id) {
		JobPracticecmp jobPracticecmp = jobPracticecmpService.getById(id);
		if(jobPracticecmp==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(jobPracticecmp);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jobPracticecmp
    */
    //@RequiresPermissions("org.jeecg.modules:job_practicecmp:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, JobPracticecmp jobPracticecmp) {
        return super.exportXls(request, jobPracticecmp, JobPracticecmp.class, "实习企业表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("job_practicecmp:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, JobPracticecmp.class);
    }

}
