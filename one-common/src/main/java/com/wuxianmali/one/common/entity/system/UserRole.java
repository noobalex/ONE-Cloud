package com.wuxianmali.one.common.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = -5303297042092593929L;

    @TableField(value = "USER_ID")
    private Long userId;

    @TableField(value = "ROLE_ID")
    private Long roleId;

}
