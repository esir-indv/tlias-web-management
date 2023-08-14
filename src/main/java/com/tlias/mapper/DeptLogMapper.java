package com.tlias.mapper;

import com.tlias.pojo.DeptLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
    void insert(DeptLog deptLog);
}
