package com.education.educationsystme.util;

import org.springframework.http.HttpHeaders;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Classname CookieUtils
 * @Description 处理cookie信息的工具类
 * @Date 2021/12/9 20:37
 * @Created by gaoqi
 */
public class CookieUtils {

    /**
     * 从请求体中获取token，默认token储存在cookie中
     * @param servletRequest 请求体
     * @return token
     */
    public static String getToken(ServletRequest servletRequest) {
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        String token = "";
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("token"))
                    token = cookies[i].getValue();
            }
        }
        return token;
    }

    /**
     * 根据参数名从cookie中获取数据
     * @param servletRequest 请求体
     * @param name 参数名
     * @return
     */
    public static String get(ServletRequest servletRequest, String name) {
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        String token = "";
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(name))
                    token = cookies[i].getValue();
            }
        }
        return token;
    }

}
