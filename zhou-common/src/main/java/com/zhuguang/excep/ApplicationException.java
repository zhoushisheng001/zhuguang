package com.zhuguang.excep;


import com.zhuguang.enummsg.ResponseCode;

/**
 * @author zhoushisheng
 * 自定义异常类
 */
public class ApplicationException extends RuntimeException {

    private ResponseCode responseCode;

    public ApplicationException(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}
