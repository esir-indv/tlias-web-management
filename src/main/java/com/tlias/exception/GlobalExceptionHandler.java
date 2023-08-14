package com.tlias.exception;

import com.tlias.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    //指定捕获哪一类的异常，这里捕获所有类型的异常
    @ExceptionHandler(Exception.class)
    public Result ex(Exception exception){
        exception.printStackTrace();
        return Result.error("对不起，操作失败，请联系管理员");
    }
}