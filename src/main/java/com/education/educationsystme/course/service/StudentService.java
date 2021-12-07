package com.education.educationsystme.course.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.educationsystme.course.mapper.StudentMapper;
import com.education.educationsystme.course.model.Student;
import org.springframework.stereotype.Service;

/**
 * @Classname StudentService
 * @Description 学生用户的业务逻辑实现
 * @Date 2021/12/7 22:59
 * @Created by gaoqi
 */
@Service
public class StudentService extends ServiceImpl<StudentMapper, Student> implements IStudentService {
}
