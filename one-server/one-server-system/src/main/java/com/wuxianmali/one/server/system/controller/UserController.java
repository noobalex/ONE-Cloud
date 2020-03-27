package com.wuxianmali.one.server.system.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wuxianmali.one.common.entity.OneResponse;
import com.wuxianmali.one.common.entity.QueryRequest;
import com.wuxianmali.one.common.entity.system.SystemUser;
import com.wuxianmali.one.common.exception.OneException;
import com.wuxianmali.one.common.utils.OneUtil;
import com.wuxianmali.one.server.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('user:view')")
    public OneResponse userList(QueryRequest queryRequest, SystemUser user) {
        Map<String, Object> dataTable = OneUtil.getDataTable(userService.findUserDetail(user, queryRequest));
        return new OneResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('user:add')")
    public void addUser(@Valid SystemUser user) throws OneException {
        try {
            this.userService.createUser(user);
        } catch (Exception e) {
            String message = "新增用户失败";
            log.error(message, e);
            throw new OneException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('user:update')")
    public void updateUser(@Valid SystemUser user) throws OneException {
        try {
            this.userService.updateUser(user);
        } catch (Exception e) {
            String message = "修改用户失败";
            log.error(message, e);
            throw new OneException(message);
        }
    }

    @DeleteMapping("/{userIds}")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public void deleteUsers(@NotBlank(message = "{required}") @PathVariable String userIds) throws OneException {
        try {
            String[] ids = userIds.split(StringPool.COMMA);
            this.userService.deleteUsers(ids);
        } catch (Exception e) {
            String message = "删除用户失败";
            log.error(message, e);
            throw new OneException(message);
        }
    }
}
