package com.tlias.mapper;

import com.tlias.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门
     */
    List<Dept> list();

    /**
     * 根据Id删除部门
     */
    void deleteById(Integer id);

    /**
     * 新增部门
     */
    void insert(Dept dept);
}
