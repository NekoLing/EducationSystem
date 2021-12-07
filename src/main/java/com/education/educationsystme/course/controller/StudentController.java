package com.education.educationsystme.course.controller;

import com.education.educationsystme.course.model.Student;
import com.education.educationsystme.course.service.StudentService;
import com.education.educationsystme.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname StudentController
 * @Description 学生用户的控制类
 * @Date 2021/12/7 23:03
 * @Created by gaoqi
 */

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    final
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "create")
    public JsonResponse create(@RequestBody Student student) {
        studentService.save(student);
        return new JsonResponse();
    }

    @PostMapping(value = "update")
    public JsonResponse update(@RequestBody Student student) {
        studentService.updateById(student);
        return new JsonResponse(studentService.getById(student.getId()), "信息修改成功");
    }
}
