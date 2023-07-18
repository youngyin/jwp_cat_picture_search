package com.yin.catsearch.domain.dto;

import com.yin.catsearch.domain.model.ImageVo;
import lombok.Data;

@Data
public class ImageDetailDto {
    private String name;
    private String id;
    private String url;
    private Integer width;
    private Integer height;
    private String temperament;
    private String origin;

    public ImageDetailDto(ImageVo imageVo) {
        setName(imageVo.getName());
        setId(imageVo.getImageId());
        setUrl(imageVo.getUrl());
        setWidth(imageVo.getWidth());
        setHeight(imageVo.getHeight());
        setTemperament(imageVo.getTemperament());
        setOrigin(imageVo.getOrigin());
    }
}
