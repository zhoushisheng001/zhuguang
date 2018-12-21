package com.zhuguang.data;

import java.io.Serializable;

/**
 * 出现异常时候返回异常对象
 * @author zhoushisheng
 */
public class ExcepResponseData implements Serializable {

    private int code;

    private String errorMsg;

    private Long time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
