package com.education.educationsystme.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

    /** ID */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 账号 */
    private String accountNumber;

    /** 密码 */
    private String password;

    /** 账户类型 */
    private Integer accountType;

    //额外属性

    /** token */
    @TableField(exist = false)
    private String token;
}
