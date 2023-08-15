package com.tlias.mapper;

import com.tlias.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateLogMapper {
    //插入日志数据
    public void insert(OperateLog log);
}
