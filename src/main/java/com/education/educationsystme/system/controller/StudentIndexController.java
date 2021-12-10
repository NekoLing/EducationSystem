package com.education.educationsystme.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname StudentIndexController
 * @Description 学生首页的控制类
 * @Date 2021/12/8 22:00
 * @Created by gaoqi
 */
@Controller
@RequestMapping(value = "/student")
public class StudentIndexController {

    @GetMapping(value = "")
    public String student() {
        return "index_student";
    }

    @GetMapping(value = "/personal.html")
    public String studentPersonal() {
        return "student/info/personal";
    }

    @GetMapping(value = "/password.html")
    public String studentPassword() {
        return "student/info/password";
    }

    @GetMapping(value = "/select.html")
    public String studentSelect() {
        return "student/course/select";
    }

    @GetMapping(value = "/score.html")
    public String studentScore() {
        return "student/course/score";
    }

    @GetMapping(value = "/table.html")
    public String studentTable() {
        return "student/course/table";
    }
}
