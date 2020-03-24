package com.wuxianmali.one.common.handler;

import com.wuxianmali.one.common.entity.OneResponse;
import com.wuxianmali.one.common.exception.OneAuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public OneResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new OneResponse().message("系统内部异常");
    }

    @ExceptionHandler(value = OneAuthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public OneResponse handleOneAuthException(OneAuthException e) {
        log.error("系统错误", e);
        return new OneResponse().message(e.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public OneResponse handleAccessDeniedException(){
        return new OneResponse().message("没有权限访问该资源");
    }
}
