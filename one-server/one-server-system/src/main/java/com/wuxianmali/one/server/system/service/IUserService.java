package com.wuxianmali.one.server.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuxianmali.one.common.entity.QueryRequest;
import com.wuxianmali.one.common.entity.system.SystemUser;

public interface IUserService extends IService<SystemUser> {

    IPage<SystemUser> findUserDetail(SystemUser user, QueryRequest request);

    void createUser(SystemUser user);

    void updateUser(SystemUser user);

    void deleteUsers(String[] userIds);

}
