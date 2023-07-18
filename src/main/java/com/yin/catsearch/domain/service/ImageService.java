package com.yin.catsearch.domain.service;

import com.yin.catsearch.domain.dto.ImageDetailDto;
import com.yin.catsearch.domain.dto.ImageDto;

import java.util.List;

public interface ImageService {
    public List<ImageDto> getRandomImageList();
    public List<ImageDto> searchByBreed(String breed);
    public ImageDetailDto searchById(String ImageId) throws Exception;
}
