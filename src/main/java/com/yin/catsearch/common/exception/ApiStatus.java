package com.yin.catsearch.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ApiStatus {
    E0000("0000", "success", HttpStatus.OK),
    E1000("1000", "No suitable data", HttpStatus.OK),
    E2000("2000", "External api communication error", HttpStatus.INTERNAL_SERVER_ERROR),
    E9999("9999", "An unknown error has occurred", HttpStatus.INTERNAL_SERVER_ERROR);

    private String code;
    private String msg;
    private HttpStatus status;
}
