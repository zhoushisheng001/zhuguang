package com.zhuguang.advice;

import com.zhuguang.data.ExcepResponseData;
import com.zhuguang.enummsg.ResponseCode;
import com.zhuguang.excep.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常拦截类
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ApplicationException.class)
    public ExcepResponseData exceptionHands (ApplicationException ex) {
        ResponseCode responseCode = ex.getResponseCode();
        ExcepResponseData exResp = new ExcepResponseData();
        exResp.setCode(responseCode.getCode());
        exResp.setErrorMsg(responseCode.getMsg());
        exResp.setTime(System.currentTimeMillis());
        return exResp;
    }
}
