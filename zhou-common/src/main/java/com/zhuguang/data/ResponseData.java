package com.zhuguang.data;

import com.zhuguang.enummsg.ResponseCode;

import java.io.Serializable;

/**
 * @author zhoushisheng
 * 正常返回对象
 * @param <T>
 */
public class ResponseData<T> implements Serializable{

    private int code;

    private String msg;

    private T data;

    private Integer totalPage; //总条数

    private Integer pageSize; //每页大小

    private Integer page; //当前页码

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

    public T getData() {
        return data;
    }

    public ResponseData setData(T data) {
        this.data = data;
        return this;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * success
     */
    public void ok() {
      this.setCode(ResponseCode.DATA_SUCCESS.getCode());
      this.setMsg(ResponseCode.DATA_SUCCESS.getMsg());
    }
}
