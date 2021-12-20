package com.education.educationsystme.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname TeacherIndexController
 * @Description 教师首页的控制类
 * @Date 2021/12/8 22:10
 * @Created by gaoqi
 */
@Controller
@RequestMapping(value = "/teacher")
public class TeacherIndexController {
    @GetMapping(value = "")
    public String teacher() {
        return "index_teacher";
    }

    @GetMapping(value = "/personal.html")
    public String teacherPersonal() {
        return "teacher/info/personal";
    }

    @GetMapping(value = "/password.html")
    public String teacherPassword() {
        return "teacher/info/password";
    }

    @GetMapping(value = "/create.html")
    public String courseCreate() {
        return "teacher/course/create";
    }

    @GetMapping(value = "/score.html")
    public String courseScore() {
        return "teacher/course/score";
    }
}
