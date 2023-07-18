package com.yin.catsearch.common.exception;

import com.yin.catsearch.common.dto.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionAdvice {

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiResponse> exceptionApiHandler(HttpServletRequest request, ApiException e){
        return ResponseEntity
                .status(e.getApiStatus().getStatus())
                .body(new ApiResponse(e.getApiStatus()));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiResponse> exceptionHandler(HttpServletRequest request){
        return ResponseEntity
                .status(ApiStatus.E9999.getStatus())
                .body(new ApiResponse(ApiStatus.E9999));
    }
}
