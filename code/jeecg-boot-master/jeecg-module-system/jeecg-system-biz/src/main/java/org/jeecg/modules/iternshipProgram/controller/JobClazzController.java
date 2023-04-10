package org.jeecg.modules.iternshipProgram.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.iternshipProgram.entity.JobClazz;
import org.jeecg.modules.iternshipProgram.service.IJobClazzService;

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
 * @Description: 班级表
 * @Author: jeecg-boot
 * @Date:   2022-09-15
 * @Version: V1.0
 */
@Api(tags="班级表")
@RestController
@RequestMapping("/JobClazz/jobClazz")
@Slf4j
public class JobClazzController extends JeecgController<JobClazz, IJobClazzService> {
	@Autowired
	private IJobClazzService jobClazzService;
	
	/**
	 * 分页列表查询
	 *
	 * @param jobClazz
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "班级表-分页列表查询")
	@ApiOperation(value="班级表-分页列表查询", notes="班级表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<JobClazz>> queryPageList(JobClazz jobClazz,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<JobClazz> queryWrapper = QueryGenerator.initQueryWrapper(jobClazz, req.getParameterMap());
		Page<JobClazz> page = new Page<JobClazz>(pageNo, pageSize);
		IPage<JobClazz> pageList = jobClazzService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param jobClazz
	 * @return
	 */
	@AutoLog(value = "班级表-添加")
	@ApiOperation(value="班级表-添加", notes="班级表-添加")
	//@RequiresPermissions("org.jeecg.modules:job_clazz:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody JobClazz jobClazz) {
		jobClazzService.save(jobClazz);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jobClazz
	 * @return
	 */
	@AutoLog(value = "班级表-编辑")
	@ApiOperation(value="班级表-编辑", notes="班级表-编辑")
	//@RequiresPermissions("org.jeecg.modules:job_clazz:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody JobClazz jobClazz) {
		jobClazzService.updateById(jobClazz);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "班级表-通过id删除")
	@ApiOperation(value="班级表-通过id删除", notes="班级表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:job_clazz:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		jobClazzService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "班级表-批量删除")
	@ApiOperation(value="班级表-批量删除", notes="班级表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:job_clazz:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.jobClazzService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "班级表-通过id查询")
	@ApiOperation(value="班级表-通过id查询", notes="班级表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<JobClazz> queryById(@RequestParam(name="id",required=true) String id) {
		JobClazz jobClazz = jobClazzService.getById(id);
		if(jobClazz==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(jobClazz);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jobClazz
    */
    //@RequiresPermissions("org.jeecg.modules:job_clazz:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, JobClazz jobClazz) {
        return super.exportXls(request, jobClazz, JobClazz.class, "班级表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("job_clazz:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, JobClazz.class);
    }

}
