package com.education.educationsystme.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    /**
     * 通过账号获得账户对象的方法，不安全，默认账号唯一
     * @param number 账号，也就是Account内的accountNumber
     * @return Account对象
     */
    @Override
    public Account getByNumber(String number) {
        return getOne(new QueryWrapper<Account>().eq("account_number", number));
    }
}
