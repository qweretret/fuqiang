package org.jeecg.modules.iternshipProgram.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.iternshipProgram.entity.JobCase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 实习方案表
 * @Author: jeecg-boot
 * @Date:   2022-09-15
 * @Version: V1.0
 */
public interface JobCaseMapper extends BaseMapper<JobCase> {

    //自定义查询
    IPage<JobCase> list(IPage page,@Param("ew")QueryWrapper<JobCase> ew);

    //查询指定的企业下的岗位
    List<JobCase> getjobCase();
}
