package org.jeecg.modules.system.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.crypto.SecureUtil;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.system.entity.JobStu;
import org.jeecg.modules.system.service.IJobStuService;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;


/**
 * @Description: 实习生基本信息表
 * @Author: jeecg-boot
 * @Date:   2022-09-14
 * @Version: V1.0
 */
@Api(tags="实习生基本信息表")
@RestController
@RequestMapping("/jobstu/jobStu")
@Slf4j
public class JobStuController extends JeecgController<JobStu, IJobStuService> {
	@Autowired
	private IJobStuService jobStuService;
	
	/**
	 * 分页列表查询
	 *
	 * @param jobStu
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "实习生基本信息表-分页列表查询")
	@ApiOperation(value="实习生基本信息表-分页列表查询", notes="实习生基本信息表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<JobStu>> queryPageList(JobStu jobStu,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<JobStu> queryWrapper = QueryGenerator.initQueryWrapper(jobStu, req.getParameterMap());
		Page<JobStu> page = new Page<JobStu>(pageNo, pageSize);
		IPage<JobStu> pageList = jobStuService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param jobStu
	 * @return
	 */
	@AutoLog(value = "实习生基本信息表-添加")
	@ApiOperation(value="实习生基本信息表-添加", notes="实习生基本信息表-添加")
	//@RequiresPermissions("org.jeecg.modules:job_stu:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody JobStu jobStu) {
		jobStu.setPaw(SecureUtil.md5(jobStu.getPaw()));
		jobStuService.save(jobStu);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jobStu
	 * @return
	 */
	@AutoLog(value = "实习生基本信息表-编辑")
	@ApiOperation(value="实习生基本信息表-编辑", notes="实习生基本信息表-编辑")
	//@RequiresPermissions("org.jeecg.modules:job_stu:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody JobStu jobStu) {
		jobStu.setPaw(SecureUtil.md5(jobStu.getPaw()));
		jobStuService.updateById(jobStu);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "实习生基本信息表-通过id删除")
	@ApiOperation(value="实习生基本信息表-通过id删除", notes="实习生基本信息表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules:job_stu:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		jobStuService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "实习生基本信息表-批量删除")
	@ApiOperation(value="实习生基本信息表-批量删除", notes="实习生基本信息表-批量删除")
	//@RequiresPermissions("org.jeecg.modules:job_stu:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.jobStuService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "实习生基本信息表-通过id查询")
	@ApiOperation(value="实习生基本信息表-通过id查询", notes="实习生基本信息表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<JobStu> queryById(@RequestParam(name="id",required=true) String id) {
		JobStu jobStu = jobStuService.getById(id);
		if(jobStu==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(jobStu);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jobStu
    */
    //@RequiresPermissions("org.jeecg.modules:job_stu:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, JobStu jobStu) {
        return super.exportXls(request, jobStu, JobStu.class, "实习生基本信息表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("job_stu:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, JobStu.class);
    }

}
