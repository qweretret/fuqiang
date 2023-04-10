package org.jeecg.modules.iternshipProgram.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Case;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.iternshipProgram.entity.JobCase;
import org.jeecg.modules.iternshipProgram.entity.JobVolunteer;
import org.jeecg.modules.iternshipProgram.service.IJobCaseService;
import org.jeecg.modules.iternshipProgram.service.IJobVolunteerService;
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
 * @Description: 实习志愿表
 * @Author: jeecg-boot
 * @Date:   2022-09-19
 * @Version: V1.0
 */
@Api(tags="实习志愿表")
@RestController
@RequestMapping("/jobVolunteer/jobVolunteer")
@Slf4j
public class JobVolunteerController extends JeecgController<JobVolunteer, IJobVolunteerService> {
	@Autowired
	private IJobVolunteerService jobVolunteerService;

	@Autowired
	private IJobCaseService jobCaseService;

	/**
	 * 分页列表查询
	 *
	 * @param jobVolunteer
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "实习志愿表-分页列表查询")
	@ApiOperation(value="实习志愿表-分页列表查询", notes="实习志愿表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<JobVolunteer>> queryPageList(JobVolunteer jobVolunteer,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<JobVolunteer> queryWrapper = QueryGenerator.initQueryWrapper(jobVolunteer, req.getParameterMap());
		Page<JobVolunteer> page = new Page<JobVolunteer>(pageNo, pageSize);
		IPage<JobVolunteer> pageList = jobVolunteerService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	@ApiOperation(value = "获取指定企业下的岗位",notes="获取指定企业下的岗位")
	@GetMapping(value="/getjobCase")
	public Result<List<JobCase>> getjobCase(){
		System.out.println("====================");
		List<JobCase> jobCases = jobCaseService.getjobCase();
		Result<List<JobCase>> t = new Result();
		t.setSuccess(true);
		t.setResult(jobCases);
		return t;
	}

	/**
	 *   添加
	 *
	 * @param jobVolunteer
	 * @return
	 */
	@AutoLog(value = "实习志愿表-添加")
	@ApiOperation(value="实习志愿表-添加", notes="实习志愿表-添加")
	//@RequiresPermissions("org.jeecg.modules:job_volunteer:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody JobVolunteer jobVolunteer) {
		jobVolunteerService.save(jobVolunteer);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jobVolunteer
	 * @return
	 */
	@AutoLog(value = "实习志愿表-编辑")
	@ApiOperation(value="实习志愿表-编辑", notes="实习志愿表-编辑")
	//@RequiresPermissions("org.jeecg.modules:job_volunteer:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody JobVolunteer jobVolunteer) {
		jobVolunteerService.updateById(jobVolunteer);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "实习志愿表-通过id删除")
	@ApiOperation(value="实习志愿表-通过id删除", notes="实习志愿表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:job_volunteer:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		jobVolunteerService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "实习志愿表-批量删除")
	@ApiOperation(value="实习志愿表-批量删除", notes="实习志愿表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:job_volunteer:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.jobVolunteerService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "实习志愿表-通过id查询")
	@ApiOperation(value="实习志愿表-通过id查询", notes="实习志愿表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<JobVolunteer> queryById(@RequestParam(name="id",required=true) String id) {
		JobVolunteer jobVolunteer = jobVolunteerService.getById(id);
		if(jobVolunteer==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(jobVolunteer);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jobVolunteer
    */
    //@RequiresPermissions("org.jeecg.modules:job_volunteer:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, JobVolunteer jobVolunteer) {
        return super.exportXls(request, jobVolunteer, JobVolunteer.class, "实习志愿表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("job_volunteer:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, JobVolunteer.class);
    }

}
