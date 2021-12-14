package com.education.educationsystme.course.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.educationsystme.course.mapper.CourseChoseMapper;
import com.education.educationsystme.course.model.Course;
import com.education.educationsystme.course.model.CourseChose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname CourseChose
 * @Description 选课的业务逻辑实现
 * @Date 2021/12/14 19:13
 * @Created by gaoqi
 */

@Service
public class CourseChoseService extends ServiceImpl<CourseChoseMapper, CourseChose> implements ICourseChoseService {
    @Autowired
    ICourseService courseService;

    @Override
    public int chose(CourseChose chose) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("student_id", chose.getStudentId());
        wrapper.eq("course_id", chose.getCourseId());

        CourseChose current = getOne(wrapper);

        if (current != null)
            return 1;
        else if (save(chose))
            return 0;
        else
            return 2;
    }

    public int unchose(CourseChose chose) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("student_id", chose.getStudentId());
        wrapper.eq("course_id", chose.getCourseId());

        if (remove(wrapper))
            return 0;
        else
            return 1;
    }

    @Override
    public List<Course> listByStuId(String id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("student_id", id);
        List<CourseChose> choses = list(wrapper);
        wrapper.clear();
        List<Course> courses = new LinkedList<>();
        for (CourseChose chose : choses) {
            courses.add(courseService.getById(chose.getCourseId()));
        }
        return courses;
    }
}
