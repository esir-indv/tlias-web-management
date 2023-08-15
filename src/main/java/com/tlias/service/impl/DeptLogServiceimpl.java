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
    //开启新的事务，插入操作日志，事务传播行为。例如：下订单前需要记录日志，不论订单保存成功与否，都要保障日志记录能够记录成功
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert (DeptLog deptlog) {
        deptLogMapper.insert(deptlog);
    }
}
