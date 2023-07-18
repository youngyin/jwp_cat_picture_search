package com.yin.catsearch.feign.dto;

public record BreedResponse (
        String id,
        String name,
        String temperament,
        String origin
) {
}
