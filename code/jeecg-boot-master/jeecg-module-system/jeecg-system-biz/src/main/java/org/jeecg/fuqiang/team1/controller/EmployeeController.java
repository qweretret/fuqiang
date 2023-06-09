package org.jeecg.fuqiang.team1.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.fuqiang.team1.entity.Employee;
import org.jeecg.fuqiang.team1.service.IEmployeeService;

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
 * @Description: 员工表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Api(tags="员工表")
@RestController
@RequestMapping("/fq/employee")
@Slf4j
public class EmployeeController extends JeecgController<Employee, IEmployeeService> {
	@Autowired
	private IEmployeeService employeeService;
	
	/**
	 * 分页列表查询
	 *
	 * @param employee
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "员工表-分页列表查询")
	@ApiOperation(value="员工表-分页列表查询", notes="员工表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Employee>> queryPageList(Employee employee,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Employee> queryWrapper = QueryGenerator.initQueryWrapper(employee, req.getParameterMap());
		Page<Employee> page = new Page<Employee>(pageNo, pageSize);
		IPage<Employee> pageList = employeeService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param employee
	 * @return
	 */
	@AutoLog(value = "员工表-添加")
	@ApiOperation(value="员工表-添加", notes="员工表-添加")
	//@RequiresPermissions("org.jeecg.modules:fq_employee:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Employee employee) {
		employeeService.save(employee);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param employee
	 * @return
	 */
	@AutoLog(value = "员工表-编辑")
	@ApiOperation(value="员工表-编辑", notes="员工表-编辑")
	//@RequiresPermissions("org.jeecg.modules:fq_employee:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Employee employee) {
		employeeService.updateById(employee);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "员工表-通过id删除")
	@ApiOperation(value="员工表-通过id删除", notes="员工表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:fq_employee:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		employeeService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "员工表-批量删除")
	@ApiOperation(value="员工表-批量删除", notes="员工表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:fq_employee:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.employeeService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "员工表-通过id查询")
	@ApiOperation(value="员工表-通过id查询", notes="员工表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Employee> queryById(@RequestParam(name="id",required=true) String id) {
		Employee employee = employeeService.getById(id);
		if(employee==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(employee);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param employee
    */
    //@RequiresPermissions("org.jeecg.modules:fq_employee:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Employee employee) {
        return super.exportXls(request, employee, Employee.class, "员工表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("fq_employee:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Employee.class);
    }

}
