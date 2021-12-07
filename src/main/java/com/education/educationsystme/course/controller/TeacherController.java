package com.education.educationsystme.course.controller;

import com.education.educationsystme.course.model.Teacher;
import com.education.educationsystme.course.service.TeacherService;
import com.education.educationsystme.system.model.Account;
import com.education.educationsystme.system.service.AccountService;
import com.education.educationsystme.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TeacherController
 * @Description 教师和管理员的控制类
 * @Date 2021/12/7 23:28
 * @Created by gaoqi
 */
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    final
    TeacherService teacherService;
    AccountService accountService;

    public TeacherController(TeacherService teacherService, AccountService accountService) {
        this.teacherService = teacherService;
        this.accountService = accountService;
    }

    @PostMapping(value = "/create")
    public JsonResponse create(@RequestBody Teacher teacher) {
        teacherService.save(teacher);

        //创建用户的同时需要创建对应的账户
        Account account = new Account();
        account.setAccountNumber(teacher.getId());
        account.setPassword("123456");
        account.setAccountType(1);
        accountService.save(account);

        return new JsonResponse();
    }

    @PostMapping(value = "/update")
    public JsonResponse update(@RequestBody Teacher teacher) {
        teacherService.updateById(teacher);
        return new JsonResponse(teacherService.getById(teacher.getId()), "信息修改成功");
    }
}
