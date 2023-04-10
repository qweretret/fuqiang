package org.jeecg.modules.iternshipProgram.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.iternshipProgram.entity.JobCase;
import org.quartz.Job;

import java.util.List;


/**
 * @Description: 实习方案表
 * @Author: jeecg-boot
 * @Date:   2022-09-15
 * @Version: V1.0
 */
public interface IJobCaseService extends IService<JobCase> {

    IPage<JobCase> list(IPage page,QueryWrapper<JobCase> ew);

    List<JobCase> getjobCase();
}
