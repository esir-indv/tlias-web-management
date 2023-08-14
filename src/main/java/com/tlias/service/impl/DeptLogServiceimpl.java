package com.tlias.service.impl;

import com.tlias.mapper.DeptLogMapper;
import com.tlias.pojo.DeptLog;
import com.tlias.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class DeptLogServiceimpl implements DeptLogService {
    @Autowired
    private DeptLogMapper deptLogMapper;
    //开启新的事务，插入操作日志
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert (DeptLog deptlog) {
        deptLogMapper.insert(deptlog);

    }
}
