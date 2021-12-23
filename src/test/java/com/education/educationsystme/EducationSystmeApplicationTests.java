package com.education.educationsystme;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.education.educationsystme.course.controller.CourseController;
import com.education.educationsystme.course.controller.StudentController;
import com.education.educationsystme.course.controller.TeacherController;
import com.education.educationsystme.course.model.Course;
import com.education.educationsystme.course.model.CourseChose;
import com.education.educationsystme.course.model.Student;
import com.education.educationsystme.course.model.Teacher;
import com.education.educationsystme.course.service.ICourseChoseService;
import com.education.educationsystme.course.service.ICourseService;
import com.education.educationsystme.course.service.StudentService;
import com.education.educationsystme.course.service.TeacherService;
import com.education.educationsystme.system.controller.AccountController;
import com.education.educationsystme.system.model.Account;
import com.education.educationsystme.system.service.AccountService;
import com.education.educationsystme.util.JwtUitls;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class EducationSystmeApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    CourseController controller;

    @Autowired
    ICourseService courseService;
    @Autowired
    ICourseChoseService choseService;
    @Autowired
    TeacherController teacherController;
    @Autowired
    StudentController studentController;

    @Test
    void test() {
        Student student = new Student();
        student.setId("00020002");
        student.setName("测试学生2");
        student.setClassNumber(2);
        student.setGrade(2020);
        student.setMajor("数学");
        studentController.create(student);
    }
}