package com.wuxianmali.one.auth.controller;

import com.wuxianmali.one.auth.service.ValidateCodeService;
import com.wuxianmali.one.common.entity.OneResponse;
import com.wuxianmali.one.common.exception.OneAuthException;
import com.wuxianmali.one.common.exception.ValidateCodeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
public class OneSecurityController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;
    @Autowired
    private ValidateCodeService validateCodeService;

//    @GetMapping("oauth/demo")
//    public String testOauth() {
//        return "oauth";
//    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public OneResponse signout(HttpServletRequest request) throws OneAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        OneResponse oneResponse = new OneResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new OneAuthException("退出登录失败");
        }
        return oneResponse.message("退出登录成功");
    }

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }
}
