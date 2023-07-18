package com.yin.catsearch.feign.dto;

import java.util.List;

public record ImageResponse(
        String id,
        String url,
        List<BreedResponse> breeds,
        Integer width,
        Integer height
) {
}
