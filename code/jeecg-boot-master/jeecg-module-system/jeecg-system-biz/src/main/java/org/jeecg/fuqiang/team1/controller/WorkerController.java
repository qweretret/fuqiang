package org.jeecg.fuqiang.team1.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.fuqiang.team1.entity.Worker;
import org.jeecg.fuqiang.team1.service.IWorkerService;

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
 * @Description: 工人表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Api(tags="工人表")
@RestController
@RequestMapping("/fq/worker")
@Slf4j
public class WorkerController extends JeecgController<Worker, IWorkerService> {
	@Autowired
	private IWorkerService workerService;
	
	/**
	 * 分页列表查询
	 *
	 * @param worker
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "工人表-分页列表查询")
	@ApiOperation(value="工人表-分页列表查询", notes="工人表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Worker>> queryPageList(Worker worker,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Worker> queryWrapper = QueryGenerator.initQueryWrapper(worker, req.getParameterMap());
		Page<Worker> page = new Page<Worker>(pageNo, pageSize);
		IPage<Worker> pageList = workerService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param worker
	 * @return
	 */
	@AutoLog(value = "工人表-添加")
	@ApiOperation(value="工人表-添加", notes="工人表-添加")
	//@RequiresPermissions("org.jeecg.modules:fq_worker:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Worker worker) {
		workerService.save(worker);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param worker
	 * @return
	 */
	@AutoLog(value = "工人表-编辑")
	@ApiOperation(value="工人表-编辑", notes="工人表-编辑")
	//@RequiresPermissions("org.jeecg.modules:fq_worker:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Worker worker) {
		workerService.updateById(worker);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "工人表-通过id删除")
	@ApiOperation(value="工人表-通过id删除", notes="工人表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:fq_worker:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		workerService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "工人表-批量删除")
	@ApiOperation(value="工人表-批量删除", notes="工人表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:fq_worker:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.workerService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "工人表-通过id查询")
	@ApiOperation(value="工人表-通过id查询", notes="工人表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Worker> queryById(@RequestParam(name="id",required=true) String id) {
		Worker worker = workerService.getById(id);
		if(worker==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(worker);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param worker
    */
    //@RequiresPermissions("org.jeecg.modules:fq_worker:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Worker worker) {
        return super.exportXls(request, worker, Worker.class, "工人表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("fq_worker:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Worker.class);
    }

}
