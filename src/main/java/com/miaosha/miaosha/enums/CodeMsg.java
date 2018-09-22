package com.miaosha.miaosha.enums;

/**
 * Created by WangPeilei
 * Time 2018/9/22 12:01
 */
public enum CodeMsg {
    SUCCESS(0,"success")
    ;
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    CodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
