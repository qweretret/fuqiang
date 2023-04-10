package org.jeecg.fuqiang.team3.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.fuqiang.team3.entity.WorkSummarize;
import org.jeecg.fuqiang.team3.service.IWorkSummarizeService;

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
 * @Description: 月度总结性工作台账
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Api(tags="月度总结性工作台账")
@RestController
@RequestMapping("/fq/workSummarize")
@Slf4j
public class WorkSummarizeController extends JeecgController<WorkSummarize, IWorkSummarizeService> {
	@Autowired
	private IWorkSummarizeService workSummarizeService;
	
	/**
	 * 分页列表查询
	 *
	 * @param workSummarize
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "月度总结性工作台账-分页列表查询")
	@ApiOperation(value="月度总结性工作台账-分页列表查询", notes="月度总结性工作台账-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<WorkSummarize>> queryPageList(WorkSummarize workSummarize,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<WorkSummarize> queryWrapper = QueryGenerator.initQueryWrapper(workSummarize, req.getParameterMap());
		Page<WorkSummarize> page = new Page<WorkSummarize>(pageNo, pageSize);
		IPage<WorkSummarize> pageList = workSummarizeService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param workSummarize
	 * @return
	 */
	@AutoLog(value = "月度总结性工作台账-添加")
	@ApiOperation(value="月度总结性工作台账-添加", notes="月度总结性工作台账-添加")
	//@RequiresPermissions("org.jeecg.modules:fq_work_summarize:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody WorkSummarize workSummarize) {
		workSummarizeService.save(workSummarize);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param workSummarize
	 * @return
	 */
	@AutoLog(value = "月度总结性工作台账-编辑")
	@ApiOperation(value="月度总结性工作台账-编辑", notes="月度总结性工作台账-编辑")
	//@RequiresPermissions("org.jeecg.modules:fq_work_summarize:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody WorkSummarize workSummarize) {
		workSummarizeService.updateById(workSummarize);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "月度总结性工作台账-通过id删除")
	@ApiOperation(value="月度总结性工作台账-通过id删除", notes="月度总结性工作台账-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:fq_work_summarize:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		workSummarizeService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "月度总结性工作台账-批量删除")
	@ApiOperation(value="月度总结性工作台账-批量删除", notes="月度总结性工作台账-批量删除")
	//@RequiresPermissions("org.jeecg.modules:fq_work_summarize:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.workSummarizeService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "月度总结性工作台账-通过id查询")
	@ApiOperation(value="月度总结性工作台账-通过id查询", notes="月度总结性工作台账-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<WorkSummarize> queryById(@RequestParam(name="id",required=true) String id) {
		WorkSummarize workSummarize = workSummarizeService.getById(id);
		if(workSummarize==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(workSummarize);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param workSummarize
    */
    //@RequiresPermissions("org.jeecg.modules:fq_work_summarize:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, WorkSummarize workSummarize) {
        return super.exportXls(request, workSummarize, WorkSummarize.class, "月度总结性工作台账");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("fq_work_summarize:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, WorkSummarize.class);
    }

}
