package com.yin.catsearch.common.exception;

import lombok.Getter;

@Getter
public class ApiException extends Exception {
    private ApiStatus apiStatus;

    public ApiException(ApiStatus apiStatus){
        this.apiStatus = apiStatus;
    }
}
