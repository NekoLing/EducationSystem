package com.education.educationsystme.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.education.educationsystme.course.model.Course;
import com.education.educationsystme.course.model.CourseChose;

import java.util.List;

/**
 * @Interfacename ICourseChose
 * @Description 选课的业务逻辑接口
 * @Date 2021/12/14 19:11
 * @Created by gaoqi
 */
public interface ICourseChoseService extends IService<CourseChose> {
    int chose(CourseChose chose);

    int unchose(CourseChose chose);

    List<Course> listByStuId(String id);
}
