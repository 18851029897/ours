package com.ours.intereptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fish on 2018/11/6.
 */
public class WeChatInterceptor extends HandlerInterceptorAdapter {

    private static Logger baseLog = LoggerFactory.getLogger(WeChatInterceptor.class);

    //在控制器执行前调用
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        baseLog.info("请求accessToken的请求URL:" + url);
        return true;
    }

    //在后端控制器执行后调用
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        baseLog.info("执行postHandle方法-->02");
    }

    //整个请求执行完成后调用
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        baseLog.info("执行afterCompletion方法-->03");
    }

}
