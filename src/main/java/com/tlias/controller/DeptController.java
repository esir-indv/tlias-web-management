package com.tlias.controller;

import com.tlias.pojo.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 部门管理
 */
@RestController
@Slf4j
//抽取公共路径
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;


    //private static final Logger log = LoggerFactory.getLogger(DeptController.class);
    //指定请求方式为GET
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    /*
     * 查询部门数据
     * */
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        //调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
    /*
     * 删除部门数据
     * */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {

        log.info("根据id删除部门：{}", id);
        //调用service
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门数据
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);
        //调用service
        deptService.add(dept);
        return Result.success();
    }

}
