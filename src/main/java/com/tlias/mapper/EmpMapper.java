package com.tlias.mapper;

import com.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //员工信息查询
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
    void delete(List<Integer> ids);
    void insert(Emp emp);
    Emp getById(Integer id);
    //更新员工
    void update(Emp emp);
    //根据用户名和密码查询员工
    Emp getByUsernameAndPassword(Emp emp);
    //根据部门ID删除该部门下的员工数据
    void deleteByDeptId(Integer deptId);
}
