package com.wuxianmali.one.common.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class OneAuthUser implements Serializable {
    private static final long serialVersionUID = -4747403470403786593L;

    private String username;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;
}
