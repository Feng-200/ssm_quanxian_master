package com.feng.ssm.service;

import com.feng.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll(Integer page, Integer size) throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(String id) throws Exception;

    void deleteById(String id) throws Exception;
}
