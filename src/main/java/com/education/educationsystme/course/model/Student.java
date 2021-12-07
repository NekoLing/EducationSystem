package com.education.educationsystme.course.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname Student
 * @Description 学生用户的实体类
 * @Date 2021/12/7 22:43
 * @Created by gaoqi
 */
@Data
@TableName(value = "course_student")
public class Student {

    /** 学号，与Account账号相同，主键 */
    private String id;

    /** 学生姓名 */
    private String name;

    /** 学生电话号码 */
    private String phone;

    /** 学生电子邮箱地址 */
    private String email;

    /** 学生年级，具体输入为入学年份 */
    private Integer grade;

    /** 学生班级 */
    private Integer classNumber;

    /** 学生专业 */
    private String major;
}
