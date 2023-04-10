package org.jeecg.fuqiang.team1.service.impl;

import org.jeecg.fuqiang.team1.entity.Employee;
import org.jeecg.fuqiang.team1.mapper.EmployeeMapper;
import org.jeecg.fuqiang.team1.service.IEmployeeService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 员工表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
