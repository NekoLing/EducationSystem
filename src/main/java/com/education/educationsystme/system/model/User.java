package com.education.educationsystme.system.model;

import lombok.Data;

/**
 * @Classname User
 * @Description 用户对象类，包括账户和对应的用户信息
 * @Date 2021/12/8 23:18
 * @Created by gaoqi
 */
@Data
public class User<T> {
    private Account account;
    private T role;
}
