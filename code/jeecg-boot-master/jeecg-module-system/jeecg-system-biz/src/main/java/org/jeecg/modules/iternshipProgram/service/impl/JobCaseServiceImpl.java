package org.jeecg.modules.iternshipProgram.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jeecg.modules.iternshipProgram.entity.JobCase;
import org.jeecg.modules.iternshipProgram.mapper.JobCaseMapper;
import org.jeecg.modules.iternshipProgram.service.IJobCaseService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 实习方案表
 * @Author: jeecg-boot
 * @Date:   2022-09-15
 * @Version: V1.0
 */
@Service
public class JobCaseServiceImpl extends ServiceImpl<JobCaseMapper, JobCase> implements IJobCaseService {

    @Resource
    private JobCaseMapper jobCaseMapper;

    @Override
    public IPage<JobCase> list(IPage page, QueryWrapper<JobCase> ew) {
        return this.jobCaseMapper.list(page,ew);
    }

    @Override
    public List<JobCase> getjobCase() {
        return this.jobCaseMapper.getjobCase();
    }
}
