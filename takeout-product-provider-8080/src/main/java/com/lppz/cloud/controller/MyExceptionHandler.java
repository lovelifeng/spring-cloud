package com.lppz.cloud.controller;

import com.lppz.cloud.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//异常处理类
@ControllerAdvice
public class MyExceptionHandler {
    //指定对应的异常类进行捕获
    @ExceptionHandler({MyException.class})
    public String handlerException(MyException e, HttpServletRequest request){

        Map<String,Object> error=new HashMap<>();
        error.put("code", e.getCode());
        error.put("massage",e.getMsg());
        request.setAttribute("ext",error);
        return "forward:/error";
    }
}
