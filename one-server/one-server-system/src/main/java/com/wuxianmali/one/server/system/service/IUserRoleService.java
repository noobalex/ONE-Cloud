package com.wuxianmali.one.server.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuxianmali.one.common.entity.system.UserRole;

public interface IUserRoleService extends IService<UserRole> {

    void deleteUserRolesByRoleId(String[] roleIds);

    void deleteUserRolesByUserId(String[] userIds);
}
