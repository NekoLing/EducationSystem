package com.education.educationsystme.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.education.educationsystme.system.model.Account;

/**
 * @Interfacename IAccountService
 * @Description 系统账户的业务逻辑接口
 * @Date 2021/11/5 22:08
 * @Created by gaoqi
 */
public interface IAccountService extends IService<Account> {

    /**
     * 根据学号/工号查询对应账户信息
     * @param number
     * @return
     */
    Account getByNumber(String number);
}
