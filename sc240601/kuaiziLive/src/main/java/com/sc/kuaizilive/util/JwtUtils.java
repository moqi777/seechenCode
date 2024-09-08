package com.sc.kuaizilive.util;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/3 9:45
 **/
public class JwtUtils {
    private static long time=1000*60*60*24;//表示有效期为24h
    private static String signature="admin";//定义签名
    public static String createToken(){//创建token的方法
        //JwtBuilder用来构建jwt
        JwtBuilder jwtBuilder= Jwts.builder();
        String jwtToken=jwtBuilder
                //header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("username","admin")
                .claim("role","user")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+time))//设置过期时间
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();//把三部分拼接起来
        return jwtToken;
    }
    //校验token的方法,其实就是解析token，如果解析成功就是可以放行
    public static boolean checkToken(String token){
        if (token==null){
            return false;
        }
        try {
            Jws<Claims> claimsJws =
                    Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
