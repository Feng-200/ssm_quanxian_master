package com.feng.ssm.service;

import com.feng.ssm.domain.Role;
import com.feng.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll(Integer page, Integer size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userid) throws Exception;

    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
