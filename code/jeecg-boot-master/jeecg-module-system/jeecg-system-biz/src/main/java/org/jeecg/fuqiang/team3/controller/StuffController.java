package org.jeecg.fuqiang.team3.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.fuqiang.team3.service.IStuffService;
import org.jeecg.fuqiang.team3.entity.Stuff;

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
 * @Description: 物料表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Api(tags="物料表")
@RestController
@RequestMapping("/fq/stuff")
@Slf4j
public class StuffController extends JeecgController<Stuff, IStuffService> {
	@Autowired
	private IStuffService stuffService;
	
	/**
	 * 分页列表查询
	 *
	 * @param stuff
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "物料表-分页列表查询")
	@ApiOperation(value="物料表-分页列表查询", notes="物料表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Stuff>> queryPageList(Stuff stuff,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Stuff> queryWrapper = QueryGenerator.initQueryWrapper(stuff, req.getParameterMap());
		Page<Stuff> page = new Page<Stuff>(pageNo, pageSize);
		IPage<Stuff> pageList = stuffService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param stuff
	 * @return
	 */
	@AutoLog(value = "物料表-添加")
	@ApiOperation(value="物料表-添加", notes="物料表-添加")
	//@RequiresPermissions("org.jeecg.modules:fq_stuff:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Stuff stuff) {
		stuffService.save(stuff);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param stuff
	 * @return
	 */
	@AutoLog(value = "物料表-编辑")
	@ApiOperation(value="物料表-编辑", notes="物料表-编辑")
	//@RequiresPermissions("org.jeecg.modules:fq_stuff:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Stuff stuff) {
		stuffService.updateById(stuff);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "物料表-通过id删除")
	@ApiOperation(value="物料表-通过id删除", notes="物料表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:fq_stuff:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		stuffService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "物料表-批量删除")
	@ApiOperation(value="物料表-批量删除", notes="物料表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:fq_stuff:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.stuffService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "物料表-通过id查询")
	@ApiOperation(value="物料表-通过id查询", notes="物料表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Stuff> queryById(@RequestParam(name="id",required=true) String id) {
		Stuff stuff = stuffService.getById(id);
		if(stuff==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(stuff);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param stuff
    */
    //@RequiresPermissions("org.jeecg.modules:fq_stuff:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Stuff stuff) {
        return super.exportXls(request, stuff, Stuff.class, "物料表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("fq_stuff:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Stuff.class);
    }

}
