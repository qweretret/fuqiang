package org.jeecg.modules.iternshipProgram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.iternshipProgram.entity.JobDept;
import org.jeecg.modules.iternshipProgram.entity.JobPracticecmp;

/**
 * @Description: 实习企业表
 * @Author: jeecg-boot
 * @Date:   2022-09-15
 * @Version: V1.0
 */
public interface JobPracticecmpMapper extends BaseMapper<JobPracticecmp> {

    /**
     * @Description: 系级表
     * @Author: jeecg-boot
     * @Date:   2022-09-15
     * @Version: V1.0
     */
    interface JobDeptMapper extends BaseMapper<JobDept> {

    }
}
