package com.education.filter;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.education.educationsystme.util.CookieUtils;
import com.education.educationsystme.util.JwtUitls;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname UserFilter
 * @Description 用户验证的过滤器
 * @Date 2021/12/8 23:25
 * @Created by gaoqi
 */
@Order(1)
@WebFilter(filterName = "userFilter", urlPatterns={"/*"})
public class UserFilter implements Filter {
    @Autowired
    JwtUitls jwtUitls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("用户过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器触发");
        Map<String,String> map = new HashMap<>();
        String url =  ((HttpServletRequest)servletRequest).getRequestURI();
        if(url != null){
            //通过登录请求和静态资源
            if(canPass(url)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }else{
                //其他请求验证token
                //从cookies中获得token
                String token = CookieUtils.getToken(servletRequest);
                if(StringUtils.isNotBlank(token)){
                    //token验证结果
                    int verify  = jwtUitls.verify(token);
                    if(verify != 1){
                        //验证失败
                        if(verify == 2){
                            map.put("state", "2");
                            map.put("message","token已过期");
                        }else if(verify == 0){
                            map.put("state", "2");
                            map.put("message","用户信息验证失败");
                        }
                    }else if(verify  == 1){
                        //验证成功，放行
                        filterChain.doFilter(servletRequest,servletResponse);
                        return;
                    }
                }else{
                    //token为空的返回
                    map.put("state", "2");
                    map.put("message","未携带token信息");
                }
            }
            Gson gson = new Gson();
            String json = gson.toJson(map);
            servletResponse.setContentType("application/json");
            //设置响应的编码
            servletResponse.setCharacterEncoding("utf-8");
            //响应
            PrintWriter pw=servletResponse.getWriter();
            pw.write(json);
            pw.flush();
            pw.close();
        }
    }


    @Override
    public void destroy() {
        System.out.println("用户过滤器销毁");
    }

    private boolean canPass(String url) {
        if (url.contains(".css"))
            return true;
        if (url.contains(".js"))
            return true;
        if ("/account/login".equals(url))
            return true;
        if ("/".equals(url))
            return true;

        return false;
    }
}
