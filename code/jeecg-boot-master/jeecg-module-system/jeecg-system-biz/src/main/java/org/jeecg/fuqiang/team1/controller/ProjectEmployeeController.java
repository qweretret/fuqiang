package org.jeecg.fuqiang.team1.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.fuqiang.team1.entity.ProjectEmployee;
import org.jeecg.fuqiang.team1.service.IProjectEmployeeService;

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
 * @Description: 员工业绩表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Api(tags="员工业绩表")
@RestController
@RequestMapping("/fq/projectEmployee")
@Slf4j
public class ProjectEmployeeController extends JeecgController<ProjectEmployee, IProjectEmployeeService> {
	@Autowired
	private IProjectEmployeeService projectEmployeeService;
	
	/**
	 * 分页列表查询
	 *
	 * @param projectEmployee
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "员工业绩表-分页列表查询")
	@ApiOperation(value="员工业绩表-分页列表查询", notes="员工业绩表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ProjectEmployee>> queryPageList(ProjectEmployee projectEmployee,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<ProjectEmployee> queryWrapper = QueryGenerator.initQueryWrapper(projectEmployee, req.getParameterMap());
		Page<ProjectEmployee> page = new Page<ProjectEmployee>(pageNo, pageSize);
		IPage<ProjectEmployee> pageList = projectEmployeeService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param projectEmployee
	 * @return
	 */
	@AutoLog(value = "员工业绩表-添加")
	@ApiOperation(value="员工业绩表-添加", notes="员工业绩表-添加")
	//@RequiresPermissions("org.jeecg.modules:fq_project_employee:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ProjectEmployee projectEmployee) {
		projectEmployeeService.save(projectEmployee);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param projectEmployee
	 * @return
	 */
	@AutoLog(value = "员工业绩表-编辑")
	@ApiOperation(value="员工业绩表-编辑", notes="员工业绩表-编辑")
	//@RequiresPermissions("org.jeecg.modules:fq_project_employee:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody ProjectEmployee projectEmployee) {
		projectEmployeeService.updateById(projectEmployee);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "员工业绩表-通过id删除")
	@ApiOperation(value="员工业绩表-通过id删除", notes="员工业绩表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:fq_project_employee:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		projectEmployeeService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "员工业绩表-批量删除")
	@ApiOperation(value="员工业绩表-批量删除", notes="员工业绩表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:fq_project_employee:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.projectEmployeeService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "员工业绩表-通过id查询")
	@ApiOperation(value="员工业绩表-通过id查询", notes="员工业绩表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<ProjectEmployee> queryById(@RequestParam(name="id",required=true) String id) {
		ProjectEmployee projectEmployee = projectEmployeeService.getById(id);
		if(projectEmployee==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(projectEmployee);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param projectEmployee
    */
    //@RequiresPermissions("org.jeecg.modules:fq_project_employee:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ProjectEmployee projectEmployee) {
        return super.exportXls(request, projectEmployee, ProjectEmployee.class, "员工业绩表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("fq_project_employee:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ProjectEmployee.class);
    }

}
