package com.education.educationsystme.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname ManagerIndexController
 * @Description 管理员首页的控制类
 * @Date 2021/12/10 14:18
 * @Created by gaoqi
 */
@Controller
@RequestMapping(value = "/manager")
public class ManagerIndexController {
    @GetMapping(value = "")
    public String manager() {
        return "index_manager";
    }

    @GetMapping(value = "/personal.html")
    public String managerPersonal() {
        return "manager/info/personal";
    }

    @GetMapping(value = "/password.html")
    public String managerPassword() {
        return "manager/info/password";
    }
}
