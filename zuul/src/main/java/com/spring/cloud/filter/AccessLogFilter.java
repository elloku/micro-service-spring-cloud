package com.spring.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：vivaciousis
 * @date ：Created in 2019/9/11 22:03
 * @description：自定义过滤器，请求响应时间
 */
@Slf4j
@Component
public class AccessLogFilter  extends ZuulFilter {

    // 发生在请求之后
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    // 在post响应之前，所以是-1
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        Long startTime = (Long)ctx.get("startTime");

        HttpServletRequest request=ctx.getRequest();
        String uri = request.getRequestURI();

        long duration = System.currentTimeMillis()-startTime;

        log.info("uri: {}, duration: {}ms", uri, duration / 100);

        return null;
    }
}

