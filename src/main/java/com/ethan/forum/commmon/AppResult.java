package com.ethan.forum.commmon;

import com.fasterxml.jackson.annotation.JsonInclude;

public class AppResult<T> {
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private int code;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String message;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private T data;


    public AppResult(int code, String message) {
        this(code,message,null);
    }
    public AppResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static AppResult success() {
        return new AppResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }
    public static AppResult success(String message) {
        return new AppResult(ResultCode.SUCCESS.getCode(), message);
    }
    public static <T> AppResult<T> success(T data) {
        return new AppResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }
    public static <T> AppResult<T> success(String message,T data) {
        return new AppResult(ResultCode.SUCCESS.getCode(),message,data);
    }

    public static AppResult failed() {
        return new AppResult(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage());
    }
    public static AppResult failed(String message) {
        return new AppResult(ResultCode.FAILED.getCode(), message);
    }
    public static AppResult failed(ResultCode resultCode) {
        return new AppResult(resultCode.getCode(), resultCode.getMessage());
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
