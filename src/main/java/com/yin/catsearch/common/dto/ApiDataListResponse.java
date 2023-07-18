package com.yin.catsearch.common.dto;

import java.util.List;

public record ApiDataListResponse<T>(
    List<T> data
) {
}
