package com.itheima.wemedia.util;

public enum AppHttpCodeEnum {

    SUCCESS(200,"操作成功"),
    ADD_ERROR(1,"新增失败"),
    UPDATE_ERROR(2,"更新失败"),
    DELETE_ERROR(3,"删除失败");

    int code;
    String errorMessage;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}