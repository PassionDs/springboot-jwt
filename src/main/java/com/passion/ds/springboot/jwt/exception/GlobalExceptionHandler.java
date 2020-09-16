package com.passion.ds.springboot.jwt.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理类
 *
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/9/16 8:58
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 描述：捕获 ArithmeticException 异常
     *
     * @param model 将Model对象注入到方法中
     * @param e     将产生异常对象注入到方法中
     * @return 指定错误页面
     */
    @ExceptionHandler(value = {ArithmeticException.class})
    public String arithmeticExceptionHandle(Model model, ArithmeticException e) {
        model.addAttribute("msg", "@ControllerAdvice + @ExceptionHandler :" + e.getMessage());
        log.info(e.getMessage());
        return "error";
    }

    /**
     * 如果需要处理其他异常，例如 NullPointerException 异常，则只需要在 GlobalException 类中定义一个方法使用 @ExceptionHandler(value = {
     * NullPointerException.class}) 注解该方法，在该方法内部处理异常就可以了。
     */
}
