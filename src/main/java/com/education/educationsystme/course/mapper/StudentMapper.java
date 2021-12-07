package com.education.educationsystme.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.education.educationsystme.course.model.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Interfacename StudentMapper
 * @Description 学生用户的映射类
 * @Date 2021/12/7 22:57
 * @Created by gaoqi
 */

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
