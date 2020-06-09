package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.ISysLogDao;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;


    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer page, Integer size) throws Exception {
        //参数pageNum是页码值   参数pageSize代表的是每页显示条数
        PageHelper.startPage(page, size);
        return sysLogDao.findAll();
    }


}
