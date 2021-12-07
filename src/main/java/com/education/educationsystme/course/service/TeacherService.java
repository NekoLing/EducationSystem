package com.education.educationsystme.course.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.educationsystme.course.mapper.TeacherMapper;
import com.education.educationsystme.course.model.Teacher;
import org.springframework.stereotype.Service;

/**
 * @Classname TeacherService
 * @Description 教师和管理员的业务逻辑实现
 * @Date 2021/12/7 23:27
 * @Created by gaoqi
 */
@Service
public class TeacherService extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {
}
