package com.education.educationsystme;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.education.educationsystme.course.controller.CourseController;
import com.education.educationsystme.course.controller.StudentController;
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


    @Test
    void test() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("student_id", "201800010001");
        List<CourseChose> choses = choseService.list(wrapper);
        wrapper.clear();
    }
}