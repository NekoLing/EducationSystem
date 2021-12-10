package com.education.educationsystme.util;

import com.education.educationsystme.system.model.Account;
import com.education.educationsystme.system.service.IAccountService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname JwtUitls
 * @Description Jwt工具类，包括token的生成和验证
 * @Date 2021/12/8 23:12
 * @Created by gaoqi
 */
@Component
public class JwtUitls {

    @Autowired
    private IAccountService accountService;

    /**
     * 过期时间20分钟
     */
    private static final long EXPIRE_TIME=20*60*1000;
    /**
     * 加密密钥
     */
    private static final String KEY = "gaoqi135";

    /**
     * 生成token
     * @param id    用户id
     * @param userName  用户名
     * @return token
     */
    public String createToken(String id,String userName){
        Map<String,Object> header = new HashMap();
        header.put("typ","JWT");
        header.put("alg","HS256");
        /*
        setID:用户ID
        setExpiration:token过期时间  当前时间+有效时间
        setSubject:用户名
        setIssuedAt:token创建时间
        signWith:加密方式 */
        JwtBuilder builder = Jwts.builder().setHeader(header)
                .setId(id)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE_TIME))
                .setSubject(userName)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,KEY);
        return builder.compact();
    }

    /**
     * 验证token是否有效
     * @param token  请求头中携带的token
     * @return  token验证结果  2-token过期；1-token认证通过；0-token认证失败
     */
    public int verify(String token){
        Claims claims = null;
        try {
            //token过期后，会抛出ExpiredJwtException 异常，通过这个来判定token过期，
            claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        }catch (ExpiredJwtException e){
            return 2;
        }
        //从token中获取用户id，查询该Id的用户是否存在，存在则token验证通过
        String id = claims.getId();
        Account account = accountService.getById(id);
        if(account != null){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 从token中获取账户类型
     * @param token
     * @return 账户类型，参考MyConstant内的常量
     */
    public int getType(String token){
        Claims claims = null;
        try {
            //token过期后，会抛出ExpiredJwtException 异常，通过这个来判定token过期，
            claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
            String id = claims.getId();
            Account account = accountService.getById(id);
            return account.getAccountType();
        }catch (ExpiredJwtException e){
            return 3;
        }
    }

    /**
     * 从token中获取账户对象
     * @param token
     * @return Account对象
     */
    public Account getAccount(String token) {
        Claims claims = null;
        try {
            //token过期后，会抛出ExpiredJwtException 异常，通过这个来判定token过期，
            claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
            String id = claims.getId();
            Account account = accountService.getById(id);
            return account;
        }catch (ExpiredJwtException e){
            return null;
        }
    }
}

