package com.education.educationsystme.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.education.educationsystme.course.model.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Interfacename TeacherMapper
 * @Description 教师和管理员的映射类
 * @Date 2021/12/7 23:25
 * @Created by gaoqi
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
}
