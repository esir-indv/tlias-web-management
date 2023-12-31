package com.tlias.mapper;

import com.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    //查询总记录数
    //@Select("select count(*) from emp")
    //public Long count();
    //分页查询
    //@Select("select * from emp limit #{start},#{pageSize}")
    //public List<Emp> page(Integer start, Integer pageSize);


    //员工信息查询

    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);
//    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUE (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp getByUsernameAndPassword(Emp emp);
}
