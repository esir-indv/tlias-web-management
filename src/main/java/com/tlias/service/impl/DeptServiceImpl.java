package com.tlias.service.impl;

import com.tlias.mapper.DeptMapper;
import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.Dept;
import com.tlias.pojo.DeptLog;
import com.tlias.service.DeptLogService;
import com.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
    //，此方法，开启事务,配置rollbackFor，所有异常都回滚，默认情况下只有RuntimeException运行异常才会回滚
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) throws Exception {
        try {
            //1、根据ID删除部门数据
            deptMapper.deleteById(id);
            //2、根据部门ID删除该部门下的员工（事务需求，需要开启事务，保障事务一致性）
            empMapper.deleteByDeptId(id);
        }
        //始终记录操作日志，无论成功还是失败
        finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此次解散的是的部门ID号为：" + id + "号部门");
            deptLogService.insert(deptLog);
        }
    }
    //新增部门操作
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }
}
