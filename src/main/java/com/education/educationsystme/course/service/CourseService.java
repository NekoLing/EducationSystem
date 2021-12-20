package com.education.educationsystme.course.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.educationsystme.course.mapper.CourseMapper;
import com.education.educationsystme.course.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname CourseService
 * @Description 课程的业务逻辑实现
 * @Date 2021/12/10 15:52
 * @Created by gaoqi
 */
@Service
public class CourseService extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Override
    public List<Course> queryByTeacher(String id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("tid", id);
        return list(wrapper);
    }
}
