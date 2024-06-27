package com.ethan.forum.exception;


import com.ethan.forum.commmon.AppResult;

//自定义异常
public class ApplicationException extends RuntimeException{
    // 在异常中持有一个错误信息对象
    protected AppResult errorResult;

    // 指定状态码，异常描述
    public ApplicationException (AppResult errorResult) {
        super(errorResult.getMessage());
        this.errorResult = errorResult;
    }

    // ⾃定义异常描述
    public ApplicationException(String message) {
        super(message);
    }
    // 指定异常
    public ApplicationException(Throwable cause) {
        super(cause);
    }
    // ⾃定义异常描述，异常信息
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
    public AppResult getErrorResult() {
        return errorResult;
    }

}
