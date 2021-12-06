package com.education.educationsystme.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.education.educationsystme.system.model.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Interfacename AccountMapper
 * @Description 系统账户的映射类
 * @Date 2021/11/5 21:48
 * @Created by gaoqi
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
