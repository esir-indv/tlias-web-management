package com.tlias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
@Slf4j
class TliasWebManagementApplicationTests {
    @Test
    //uuid
    void testUuid(){
        for (int i = 0; i < 1000; i++) {
           log.info(UUID.randomUUID().toString());
        }
    }
    @Test
    void gitHubTest(){
        log.info("gitHubTest");
    }
    @Test
    void testGenJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("地点","Homeinn");
        claims.put("time","2022-03-03");
        String jwt = Jwts.builder()
                //签名算法,密钥不能太短，最短四个字符
                .signWith(SignatureAlgorithm.HS256,"fengliang")
                //自定义内容(载荷)
                .setClaims(claims)
                //设置有效期为一个小时
                .setExpiration(new Date((System.currentTimeMillis()+3600*1000)))
                //拼接字符串
                .compact();
        log.info("JWT令牌："+ jwt);
    }
   //解析JWT令牌
    @Test
    void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("fengliang")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyLlnLDngrkiOiJIb21laW5uIiwidGltZSI6IjIwMjItMDMtMDMiLCJleHAiOjE2OTE2NjE1MzB9.RV_LZNMy00Ir-7kkdHyjspMXeV-8veAvOjFBG3q8rmI")
                .getBody();
        log.info("解析令牌："+claims);
    }
}
