package com.yin.catsearch.common.dto;

import com.yin.catsearch.common.exception.ApiStatus;
import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private String errCode;
    private String errMsg;
    private T data;

    public ApiResponse(ApiStatus status){
        this.errCode = status.getCode();
        this.errMsg = status.getMsg();
    }
}
