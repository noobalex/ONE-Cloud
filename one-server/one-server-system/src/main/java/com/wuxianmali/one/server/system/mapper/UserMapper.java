package com.wuxianmali.one.server.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuxianmali.one.common.entity.system.SystemUser;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<SystemUser> {

    IPage<SystemUser> findUserDetailPage(Page page, @Param("user") SystemUser user);
}
