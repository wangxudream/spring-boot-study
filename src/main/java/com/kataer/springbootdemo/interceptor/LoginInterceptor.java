package com.kataer.springbootdemo.interceptor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现HandlerInterceptor接口
 * 内部有三个默认方法
 * 1、default boolean preHandle 访问控制器方法前执行 返回true后，controller方法才会被执行，postHandle方法和afterCompletion才会被执行
 * 2、default void postHandle   访问控制器方法后执行
 * 3、default void afterCompletion  postHandle方法执行后执行，通常用于释放资源
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("LoginInterceptor------>");
        log.info("request url ------>" + request.getRequestURI());
        if (!(handler instanceof HandlerMethod)) {
            return false;
        }

        Parameter[] parameters = ((HandlerMethod) handler).getMethod().getParameters();
        for (Parameter parameter : parameters) {
            String key = parameter.getName();
            String value = request.getParameter(key);
            log.info(key + ":" + value);
            if (value == null || value.trim().equals("")) {
                log.info(parameter.getName() + ":为空");
                Map<String, String> result = new HashMap<>();
                result.put("code", "404");
                result.put("msg", parameter.getName() + "为空");
                response.setHeader("Content-type", "application/json;charset=UTF-8");
                response.setHeader("Access-Control-Allow-Origin", "*");//跨域
                response.getWriter().write(JSON.toJSONString(result));
                return false;
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle()");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion()");
    }
}
