package com.education.educationsystme.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname IndexController
 * @Description 主页的控制类
 * @Date 2021/12/7 21:43
 * @Created by gaoqi
 */
@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/student")
    public String student() {
        return "error";
    }
}
