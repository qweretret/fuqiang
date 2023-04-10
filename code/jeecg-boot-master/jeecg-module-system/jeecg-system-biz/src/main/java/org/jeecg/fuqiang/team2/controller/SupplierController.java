package org.jeecg.fuqiang.team2.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.fuqiang.team2.entity.Supplier;
import org.jeecg.fuqiang.team2.service.ISupplierService;

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
 * @Description: 供应商表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Api(tags="供应商表")
@RestController
@RequestMapping("/fq/supplier")
@Slf4j
public class SupplierController extends JeecgController<Supplier, ISupplierService> {
	@Autowired
	private ISupplierService supplierService;
	
	/**
	 * 分页列表查询
	 *
	 * @param supplier
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "供应商表-分页列表查询")
	@ApiOperation(value="供应商表-分页列表查询", notes="供应商表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Supplier>> queryPageList(Supplier supplier,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Supplier> queryWrapper = QueryGenerator.initQueryWrapper(supplier, req.getParameterMap());
		Page<Supplier> page = new Page<Supplier>(pageNo, pageSize);
		IPage<Supplier> pageList = supplierService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param supplier
	 * @return
	 */
	@AutoLog(value = "供应商表-添加")
	@ApiOperation(value="供应商表-添加", notes="供应商表-添加")
	//@RequiresPermissions("org.jeecg.modules:fq_supplier:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Supplier supplier) {
		supplierService.save(supplier);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param supplier
	 * @return
	 */
	@AutoLog(value = "供应商表-编辑")
	@ApiOperation(value="供应商表-编辑", notes="供应商表-编辑")
	//@RequiresPermissions("org.jeecg.modules:fq_supplier:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Supplier supplier) {
		supplierService.updateById(supplier);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "供应商表-通过id删除")
	@ApiOperation(value="供应商表-通过id删除", notes="供应商表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:fq_supplier:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		supplierService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "供应商表-批量删除")
	@ApiOperation(value="供应商表-批量删除", notes="供应商表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:fq_supplier:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.supplierService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "供应商表-通过id查询")
	@ApiOperation(value="供应商表-通过id查询", notes="供应商表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Supplier> queryById(@RequestParam(name="id",required=true) String id) {
		Supplier supplier = supplierService.getById(id);
		if(supplier==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(supplier);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param supplier
    */
    //@RequiresPermissions("org.jeecg.modules:fq_supplier:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Supplier supplier) {
        return super.exportXls(request, supplier, Supplier.class, "供应商表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("fq_supplier:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Supplier.class);
    }

}
