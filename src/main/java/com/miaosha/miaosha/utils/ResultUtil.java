package com.miaosha.miaosha.utils;

import com.miaosha.miaosha.vo.enums.CodeMsg;
import com.miaosha.miaosha.vo.Result;

/**
 * Created by WangPeilei
 * Time 2018/9/22 12:13
 */
public class ResultUtil {

    public static Result<Object> success(CodeMsg codeMsg, Object object) {
        Result<Object> result = new Result<>();
        result.setCode(codeMsg.getCode());
        result.setMsg(codeMsg.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success(CodeMsg codeMsg) {
        return success(codeMsg ,null);
    }

    public static Result success(Object object) {
        return success(CodeMsg.SUCCESS, object);
    }

    public static Result error(CodeMsg codeMsg) {
        Result result = new Result();
        result.setCode(codeMsg.getCode());
        result.setMsg(codeMsg.getMsg());
        return result;
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
