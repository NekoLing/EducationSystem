package com.education.educationsystme.course.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname CourseChose
 * @Description 选课
 * @Date 2021/12/14 19:15
 * @Created by gaoqi
 */

@Data
public class CourseChose {
    private String studentId;
    private Integer courseId;
    private Float score;
}
