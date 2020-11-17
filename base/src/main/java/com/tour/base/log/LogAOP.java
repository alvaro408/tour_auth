package com.tour.base.log;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Order(2)
public class LogAOP {

    private static Logger logger = LoggerFactory.getLogger(LogAOP.class);

    @Pointcut("execution(public * com.tour.*.web..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void printLog(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("URL: {}", request.getRequestURL().toString());
        logger.info("HTTP_METHOD: {}", request.getMethod());
        logger.info("IP: {}", request.getRemoteAddr());
        logger.info("CLASS_METHOD: {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        logger.info("PARAM: ", JSONObject.toJSONString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "webLog()", returning = "ret")
    public void afterReturning(Object ret) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("HTTP_METHOD: {}, RESPONSE: {}", request.getMethod(), JSONObject.toJSONString(ret));
    }

}
