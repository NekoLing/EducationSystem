package com.education.educationsystme.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.education.educationsystme.course.model.Course;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Interfacename CourseMapper
 * @Description 课程的映射类
 * @Date 2021/12/10 15:50
 * @Created by gaoqi
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
