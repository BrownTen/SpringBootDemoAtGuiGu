package com.wyt.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler extends RuntimeException{
    //1.浏览器客户端返回的都是JSON数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handlerException(Exception e){
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("code","user not exist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        //传入我们自己的错误状态码
        /**
         * 		Integer statusCode = (Integer) request
         * 				.getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user not exist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        //转发到/error
        return "forward:/error";
    }
}
