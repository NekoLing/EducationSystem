package com.education.educationsystme.system.controller;

import com.education.educationsystme.system.model.Account;
import com.education.educationsystme.system.service.AccountService;
import com.education.educationsystme.util.JsonResponse;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname AccountController
 * @Description 系统账户的控制层
 * @Date 2021/11/5 22:19
 * @Created by gaoqi
 */

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "/create")
    public JsonResponse create(@RequestBody Account account) {
        accountService.save(account);
        return new JsonResponse();
    }

    @PostMapping(value = "/query")
    public JsonResponse queryByID(@RequestParam String id) {
        return new JsonResponse(accountService.getById(id));
    }

    @PostMapping(value = "/login")
    public JsonResponse login(@RequestBody Account inputAccount) {
        Account saveAccount = accountService.getById(inputAccount.getId());
        if (saveAccount == null)
            return new JsonResponse(1, "用户不存在");
        else if (!saveAccount.getPassword().equals(inputAccount.getPassword()))
            return new JsonResponse(1, "密码错误");
        else
            return new JsonResponse(0,"登录成功");
    }
}
