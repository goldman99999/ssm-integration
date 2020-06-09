package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface IRoleDao {


    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="roleName",property="roleName"),
            @Result(column="roleDesc",property="roleDesc"),
            @Result(column="id",property="permissions",javaType=java.util.List.class,
                    many=@Many(select="com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;



    @Select("select * from role")
    public List<Role> findAll() throws Exception;



    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void save(Role role) throws Exception;



    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "id", property = "permissions", javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public Role findById(String roleId) throws Exception;



    @Select("select * from permission where id not in " +
            "(select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findOtherPermissions(String roleId) throws Exception;



    @Insert("insert into role_permission(roleId, permissionId) " +
            "values(#{roleId}, #{permissionId})")
    public void addPermissionToRole(
            @Param("roleId") String roleId, @Param("permissionId") String permissionId)
            throws Exception;


}


