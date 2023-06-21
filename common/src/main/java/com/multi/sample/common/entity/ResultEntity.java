package com.multi.sample.common.entity;

import com.multi.sample.common.type.Result;
import com.multi.sample.common.utils.CommonMessage;

import java.io.Serializable;
import java.util.Map;

public class ResultEntity<T> implements Serializable {

    private static final long serialVersionUID = -3104101773843743888L;

    private String code    = Result.SUCCESS.getCode();
    private String message = CommonMessage.getMessage("server.result.success");
    private T data;

    public ResultEntity() {}

    public ResultEntity(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultEntity(T data) {
        this.data = data;
    }

    public ResultEntity(String code, String message, final T data) {
        this(code, message);
        this.data = data;
    }

    public static ResultEntity create(){
        return new ResultEntity();
    }

    public static ResultEntity of(String code, String message){
        return new ResultEntity(code, message);
    }

    public static ResultEntity ok(Object data){
        return new ResultEntity(data);
    }

    public ResultEntity data(T data){
        this.data = data;
        return this;
    }

    public static ResultEntity fail(Map<String, Object> data){
        return new ResultEntity()
                .setCode(Result.FAIL.getCode())
                .setMessage(CommonMessage.getMessage("server.result.fail"))
                .setData(data);
    }

    public String getCode() {
        return code;
    }

    public ResultEntity<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultEntity<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultEntity<T> setData(T data) {
        this.data = data;
        return this;
    }
}
