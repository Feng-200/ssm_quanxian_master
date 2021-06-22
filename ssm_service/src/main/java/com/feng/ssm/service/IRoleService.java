package com.feng.ssm.service;

import com.feng.ssm.domain.Permission;
import com.feng.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll(Integer page, Integer size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);

    void deleteRoleById(String roleId) throws Exception;
}
