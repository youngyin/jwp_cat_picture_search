package com.yin.catsearch.common.dto;

public record ApiDataResponse<T> (
    T data
) {

}
