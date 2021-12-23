package com.education.educationsystme.course.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.educationsystme.course.mapper.CourseChoseMapper;
import com.education.educationsystme.course.model.Course;
import com.education.educationsystme.course.model.CourseChose;
import com.education.educationsystme.course.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    final
    IStudentService studentService;
    final
    ICourseService courseService;

    public CourseChoseService(ICourseService courseService, IStudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @Override
    public int chose(CourseChose chose) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("student_id", chose.getStudentId());
        wrapper.eq("course_id", chose.getCourseId());

        CourseChose current = getOne(wrapper);

        Course course = courseService.getById(chose.getCourseId());
        String dataString = course.getDeadline();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date deadline = format.parse(dataString);
            Date currentDate = new Date();
            if (currentDate.after(deadline))
                return 3;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (current != null)
            return 1;
        else if (save(chose)) {
            wrapper.clear();
            wrapper.eq("id", course.getId());
            course.setAllowance(course.getAllowance() - 1);
            courseService.update(course, wrapper);
            return 0;
        }
        else
            return 2;
    }

    public int unchose(CourseChose chose) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("student_id", chose.getStudentId());
        wrapper.eq("course_id", chose.getCourseId());

        if (remove(wrapper)) {
            Course course = courseService.getById(chose.getCourseId());
            course.setAllowance(course.getAllowance() - 1);
            wrapper.clear();
            wrapper.eq("id", course.getId());
            courseService.update(course, wrapper);
            return 0;
        }
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
        Course course;
        for (CourseChose chose : choses) {
            course = courseService.getById(chose.getCourseId());
            course.setScore(chose.getScore());
            courses.add(course);
        }
        return courses;
    }

    @Override
    public List<Student> listStudentById(Integer id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("course_id", id);
        List<CourseChose> choses = list(wrapper);
        wrapper.clear();
        List<Student> students = new LinkedList<>();
        Student student;
        for (CourseChose chose : choses) {
            student = studentService.getById(chose.getStudentId());
            student.setScore(chose.getScore());
            students.add(student);
        }
        return students;
    }

    @Override
    public int updateScore(CourseChose chose) {
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("course_id", chose.getCourseId());
        wrapper.eq("student_id", chose.getStudentId());
        wrapper.set("score", chose.getScore());
        update(wrapper);
        return 0;
    }
}
