package com.wuxianmali.one.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuxianmali.one.common.entity.system.SystemUser;

public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}
