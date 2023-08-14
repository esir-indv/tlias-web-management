package com.tlias.service;

import com.tlias.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询全部部门数据*/
    List<Dept> list();

    /**删除部门
     *
     */
    void delete(Integer id) throws Exception;

    /**
     * 新增部门
     */
    void add(Dept dept) ;

}
