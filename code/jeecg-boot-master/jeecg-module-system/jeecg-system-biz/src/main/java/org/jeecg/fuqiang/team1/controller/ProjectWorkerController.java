package org.jeecg.fuqiang.team1.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.fuqiang.team1.entity.ProjectWorker;
import org.jeecg.fuqiang.team1.service.IProjectWorkerService;

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
 * @Description: 工人-项目表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Api(tags="工人-项目表")
@RestController
@RequestMapping("/fq/projectWorker")
@Slf4j
public class ProjectWorkerController extends JeecgController<ProjectWorker, IProjectWorkerService> {
	@Autowired
	private IProjectWorkerService projectWorkerService;
	
	/**
	 * 分页列表查询
	 *
	 * @param projectWorker
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "工人-项目表-分页列表查询")
	@ApiOperation(value="工人-项目表-分页列表查询", notes="工人-项目表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ProjectWorker>> queryPageList(ProjectWorker projectWorker,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<ProjectWorker> queryWrapper = QueryGenerator.initQueryWrapper(projectWorker, req.getParameterMap());
		Page<ProjectWorker> page = new Page<ProjectWorker>(pageNo, pageSize);
		IPage<ProjectWorker> pageList = projectWorkerService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param projectWorker
	 * @return
	 */
	@AutoLog(value = "工人-项目表-添加")
	@ApiOperation(value="工人-项目表-添加", notes="工人-项目表-添加")
	//@RequiresPermissions("org.jeecg.modules:fq_project_worker:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ProjectWorker projectWorker) {
		projectWorkerService.save(projectWorker);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param projectWorker
	 * @return
	 */
	@AutoLog(value = "工人-项目表-编辑")
	@ApiOperation(value="工人-项目表-编辑", notes="工人-项目表-编辑")
	//@RequiresPermissions("org.jeecg.modules:fq_project_worker:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody ProjectWorker projectWorker) {
		projectWorkerService.updateById(projectWorker);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "工人-项目表-通过id删除")
	@ApiOperation(value="工人-项目表-通过id删除", notes="工人-项目表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:fq_project_worker:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		projectWorkerService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "工人-项目表-批量删除")
	@ApiOperation(value="工人-项目表-批量删除", notes="工人-项目表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:fq_project_worker:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.projectWorkerService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "工人-项目表-通过id查询")
	@ApiOperation(value="工人-项目表-通过id查询", notes="工人-项目表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<ProjectWorker> queryById(@RequestParam(name="id",required=true) String id) {
		ProjectWorker projectWorker = projectWorkerService.getById(id);
		if(projectWorker==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(projectWorker);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param projectWorker
    */
    //@RequiresPermissions("org.jeecg.modules:fq_project_worker:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ProjectWorker projectWorker) {
        return super.exportXls(request, projectWorker, ProjectWorker.class, "工人-项目表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("fq_project_worker:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ProjectWorker.class);
    }

}
