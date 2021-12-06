package com.education.educationsystme.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname Account
 * @Description 系统账户的模型类
 * @Date 2021/11/5 21:03
 * @Created by gaoqi
 */

@Data
@TableName(value = "system_account")
public class Account {
    /** 账号15位 3位字母 + 12位数字 */
    private String id;

    /** 姓名 */
    private String name;

    /** 密码 */
    private String password;

    /** 邮箱 */
    private String email;

    /** 电话号码 */
    private Long phone;

    /** 地址 */
    private String address;

    /** 年级 */
    private Integer grade;

    /** 班级 */
    private Integer classNumber;

    /** 专业 */
    private String major;

    /** 账户类型 */
    private Integer accountType;
}
