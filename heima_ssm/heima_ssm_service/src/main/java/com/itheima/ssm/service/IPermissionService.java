package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {


    public List<Permission> findAll(int page, int size) throws Exception;


    public void save(Permission permission) throws Exception;


}
