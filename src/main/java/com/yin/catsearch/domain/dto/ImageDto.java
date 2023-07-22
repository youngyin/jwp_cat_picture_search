package com.yin.catsearch.domain.dto;

import com.yin.catsearch.domain.model.ImageVo;
import com.yin.catsearch.feign.dto.ImageResponse;
import lombok.Data;

@Data
public class ImageDto {
    private String id;
    private String url;
    private String name;

    public ImageDto(ImageVo imageVo){
        setId(imageVo.getImageId());
        setUrl(imageVo.getUrl());
        setName(imageVo.getName());
    }

    public ImageDto() {

    }
}
