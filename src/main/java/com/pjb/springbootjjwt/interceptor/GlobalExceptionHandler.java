package com.pjb.springbootjjwt.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.pjb.springbootjjwt.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jinbin
 * @date 2018-07-08 22:37
 */
@ResponseBody
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();
        if (StringUtils.isEmpty(msg)) {
            msg = "服务器出错";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Exception ---->   message", msg);
        log.error(jsonObject.toString());
        return jsonObject;
    }

    @ExceptionHandler(CustomException.class)
    public Object handleCustomException(Exception e) {
        String msg = e.getMessage();
        if (StringUtils.isEmpty(msg)) {
            msg = "用户服务出错";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("CustomException ---->   message", msg);
        log.error(jsonObject.toString());
        return jsonObject;
    }

}
