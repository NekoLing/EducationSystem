package com.education.educationsystme.course.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname Course
 * @Description 课程的实体类
 * @Date 2021/12/10 15:46
 * @Created by gaoqi
 */

@Data
@TableName(value = "Course")
public class Course {

  @TableId(type = IdType.AUTO)
  private Integer id;

  private String tid;

  private String name;

  /** 学分 */
  private Double credit;

  /** 学年 格式为 2018-1 */
  private String year;

  /** 上课周和日期 格式为 1-17-1234567 */
  private String week;

  /** 上课节次 */
  private Integer classtime;

  /** 上课地点 */
  private String location;

  private String classroom;

  /** 类型 必修0 选修1 */
  private Integer type;

  /** 课余量 */
  private Integer allowance;

  /** 截止日期 */
  private String deadline;


  //额外属性

  /** 成绩 */
  @TableField(exist = false)
  private Float score;
}
