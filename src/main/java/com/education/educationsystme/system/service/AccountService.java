package com.education.educationsystme.system.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.educationsystme.system.mapper.AccountMapper;
import com.education.educationsystme.system.model.Account;
import org.springframework.stereotype.Service;

/**
 * @Classname AccountService
 * @Description 系统账户的业务逻辑实现
 * @Date 2021/11/5 22:10
 * @Created by gaoqi
 */
@Service
public class AccountService extends ServiceImpl<AccountMapper, Account> implements IAccountService {
}
