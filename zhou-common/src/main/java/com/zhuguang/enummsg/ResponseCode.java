package com.zhuguang.enummsg;


/**
 * 异常类型枚举
 */
public enum ResponseCode {
    DATA_SUCCESS(0,"success"),
    GET_ITEM_INFO_EXCE(4000,"获得商品信息异常"),
    ;
    private int code;

    private String msg;

    private ResponseCode() {
    }

    private ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
