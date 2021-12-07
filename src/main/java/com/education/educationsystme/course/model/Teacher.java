package com.education.educationsystme.course.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname Teacher
 * @Description 教师和管理员用户的实体类
 * @Date 2021/12/7 23:22
 * @Created by gaoqi
 */
@Data
@TableName(value = "course_teacher")
public class Teacher {

    /** 教师和管理员的工号 */
    private String id;

    /** 教师和管理员的姓名 */
    private String name;

    /** 教师和管理员的电话号码 */
    private String phone;

    /** 教师和管理员的电子邮箱地址 */
    private String email;
}
