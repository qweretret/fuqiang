package org.jeecg.fuqiang.team1.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.fuqiang.team1.entity.EmployeeCertificate;
import org.jeecg.fuqiang.team1.service.IEmployeeCertificateService;

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
 * @Description: 员工证书表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Api(tags="员工证书表")
@RestController
@RequestMapping("/fq/employeeCertificate")
@Slf4j
public class EmployeeCertificateController extends JeecgController<EmployeeCertificate, IEmployeeCertificateService> {
	@Autowired
	private IEmployeeCertificateService employeeCertificateService;
	
	/**
	 * 分页列表查询
	 *
	 * @param employeeCertificate
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "员工证书表-分页列表查询")
	@ApiOperation(value="员工证书表-分页列表查询", notes="员工证书表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<EmployeeCertificate>> queryPageList(EmployeeCertificate employeeCertificate,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<EmployeeCertificate> queryWrapper = QueryGenerator.initQueryWrapper(employeeCertificate, req.getParameterMap());
		Page<EmployeeCertificate> page = new Page<EmployeeCertificate>(pageNo, pageSize);
		IPage<EmployeeCertificate> pageList = employeeCertificateService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param employeeCertificate
	 * @return
	 */
	@AutoLog(value = "员工证书表-添加")
	@ApiOperation(value="员工证书表-添加", notes="员工证书表-添加")
	//@RequiresPermissions("org.jeecg.modules:fq_employee_certificate:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody EmployeeCertificate employeeCertificate) {
		employeeCertificateService.save(employeeCertificate);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param employeeCertificate
	 * @return
	 */
	@AutoLog(value = "员工证书表-编辑")
	@ApiOperation(value="员工证书表-编辑", notes="员工证书表-编辑")
	//@RequiresPermissions("org.jeecg.modules:fq_employee_certificate:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody EmployeeCertificate employeeCertificate) {
		employeeCertificateService.updateById(employeeCertificate);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "员工证书表-通过id删除")
	@ApiOperation(value="员工证书表-通过id删除", notes="员工证书表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:fq_employee_certificate:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		employeeCertificateService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "员工证书表-批量删除")
	@ApiOperation(value="员工证书表-批量删除", notes="员工证书表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:fq_employee_certificate:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.employeeCertificateService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "员工证书表-通过id查询")
	@ApiOperation(value="员工证书表-通过id查询", notes="员工证书表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<EmployeeCertificate> queryById(@RequestParam(name="id",required=true) String id) {
		EmployeeCertificate employeeCertificate = employeeCertificateService.getById(id);
		if(employeeCertificate==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(employeeCertificate);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param employeeCertificate
    */
    //@RequiresPermissions("org.jeecg.modules:fq_employee_certificate:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, EmployeeCertificate employeeCertificate) {
        return super.exportXls(request, employeeCertificate, EmployeeCertificate.class, "员工证书表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("fq_employee_certificate:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, EmployeeCertificate.class);
    }

}
