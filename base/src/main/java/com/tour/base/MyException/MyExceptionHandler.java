package com.tour.base.MyException;

import com.tour.base.model.RespInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public RespInfo defaultHandler(HttpServletRequest request, Exception e) {
        RespInfo respInfo = new RespInfo();
        respInfo.setRspCode("-100");
        respInfo.setRspDesc("系统错误");
        logger.error("##### 异常: {} #####", e);
        respInfo.setUrl(request.getRequestURL().toString());
        return respInfo;
    }

}
