package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IPermissionDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll(int page, int size) throws Exception {
        //参数pageNum是页码值   参数pageSize代表的是每页显示条数
        PageHelper.startPage(page, size);
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
