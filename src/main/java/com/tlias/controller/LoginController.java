package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import com.tlias.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登陆：{}", emp);
        Emp e = empService.login(emp);
        //登陆成功，生成令牌，下发令牌
        if (e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());
            //jwt中包含了当前员工登陆信息
            String jwt = JwtUtils.generateJwt(claims);
            log.info("JWT:"+jwt);
            return Result.success(jwt);
        }
        //登陆失败，返回错误信息
        return Result.error("用户名或密码错误");
    }
}
