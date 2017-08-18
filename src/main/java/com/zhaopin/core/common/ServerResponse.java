package com.zhaopin.core.common;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by SYJ on 2017/5/19.
 */
public class ServerResponse<T> implements Serializable {

    private int code;
    private String message;
    private T data;
    private String taskId = UUID.randomUUID().toString();

    private ServerResponse(int code){
        this.code = code;
    }
    private ServerResponse(int code, T data){
        this.code = code;
        this.data = data;
    }

    private ServerResponse(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ServerResponse(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }
    public T getData(){
        return data;
    }
    public String getMessage(){
        return message;
    }

    public String getTaskId() {
        return taskId;
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String message){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),message);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String message,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),message,data);
    }


    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }


    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }
}
