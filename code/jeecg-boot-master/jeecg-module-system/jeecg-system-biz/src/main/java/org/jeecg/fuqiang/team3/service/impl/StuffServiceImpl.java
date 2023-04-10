package org.jeecg.fuqiang.team3.service.impl;

import org.jeecg.fuqiang.team3.service.IStuffService;
import org.jeecg.fuqiang.team3.entity.Stuff;
import org.jeecg.fuqiang.team3.mapper.StuffMapper;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 物料表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Service
public class StuffServiceImpl extends ServiceImpl<StuffMapper, Stuff> implements IStuffService {

}
