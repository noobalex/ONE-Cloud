package com.wuxianmali.one.gateway.filter;

import com.netflix.zuul.context.RequestContext;
import com.wuxianmali.one.common.entity.OneResponse;
import com.wuxianmali.one.common.utils.OneUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class OneGatewayErrorFilter extends SendErrorFilter {
    @Override
    public Object run() {
        try {
            OneResponse oneResponse = new OneResponse();
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);

            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            String errorCause = exception.getErrorCause();
            Throwable throwable = exception.getThrowable();
            String message = throwable.getMessage();
            message = StringUtils.isBlank(message) ? errorCause : message;
            oneResponse = resolveExceptionMessage(message, serviceId, oneResponse);

            HttpServletResponse response = ctx.getResponse();
            OneUtil.makeResponse(
                    response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR, oneResponse
            );
            log.error("Zull sendError：{}", oneResponse.getMessage());
        } catch (Exception ex) {
            log.error("Zuul sendError", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private OneResponse resolveExceptionMessage(String message, String serviceId, OneResponse oneResponse) {
        if (StringUtils.containsIgnoreCase(message, "time out")) {
            return oneResponse.message("请求" + serviceId + "服务超时");
        }
        if (StringUtils.containsIgnoreCase(message, "forwarding error")) {
            return oneResponse.message(serviceId + "服务不可用");
        }
        return oneResponse.message("Zuul请求" + serviceId + "服务异常");
    }
}
