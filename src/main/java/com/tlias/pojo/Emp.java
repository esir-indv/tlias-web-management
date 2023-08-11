package com.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * 员工实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Emp {
    //ID
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //姓名
    private String name;
    //性别 , 1 男, 2 女
    private Short gender;
    //图像url
    private String image;
    //职位 , 1 班主任 , 2 讲师 , 3 学工主管 , 4 教研主管 , 5 咨询师
    private Short job;
    //入职日期
    private LocalDate entrydate;
    //部门ID
    private Integer deptId;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
    private LocalDateTime updateTime;
}
