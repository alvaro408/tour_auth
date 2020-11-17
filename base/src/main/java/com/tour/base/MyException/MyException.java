package com.tour.base.MyException;

import com.tour.base.model.RespInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyException {

    private static Logger logger = LoggerFactory.getLogger(MyException.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public RespInfo defaultHandler(HttpServletRequest request, Exception e) {
        RespInfo respInfo = new RespInfo();
        respInfo.setRspCode("-100");
        respInfo.setRspDesc(e.getMessage());
        respInfo.setUrl(request.getRequestURL().toString());
        return respInfo;
    }

}
