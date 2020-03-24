package com.wuxianmali.one.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.wuxianmali.one.common.entity.OneResponse;
import com.wuxianmali.one.common.utils.OneUtil;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneAuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        OneResponse oneResponse = new OneResponse();
        OneUtil.makeResponse(
                httpServletResponse,
                MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_UNAUTHORIZED,
                oneResponse.message("token无效"));
    }
}
