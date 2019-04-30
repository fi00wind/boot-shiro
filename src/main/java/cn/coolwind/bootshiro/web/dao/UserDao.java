package cn.coolwind.bootshiro.web.dao;

import cn.coolwind.bootshiro.web.entity.Permission;
import cn.coolwind.bootshiro.web.entity.User;

import java.util.List;

public interface UserDao {
    User getByUsername(String username);

    List<String> getRolesByUserId(Integer id);

    List<String> getPermissionByUserId(Integer id);

    List<Permission> getAllPermission();

    void deleteRolePermission(Integer roleId);

    void insertRolePermission(Integer roleId, Integer[] permissionIds);
}
