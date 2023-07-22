package com.yin.catsearch.domain.service;

import com.yin.catsearch.common.exception.ApiException;
import com.yin.catsearch.domain.dto.ImageDetailDto;
import com.yin.catsearch.domain.dto.ImageDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ImageServiceImplTest {

    private final ImageService imageService;

    @Autowired
    ImageServiceImplTest(ImageService imageService) {
        this.imageService = imageService;
    }

    @Test
    void getRandomImageList() {
        List<ImageDto> imgList = imageService.getRandomImageList(10);
        Assertions.assertEquals(10, imgList.size());
    }

    @Test
    void searchByBreed() {
        List<ImageDto> imgList;

        // 유효하지 않은 품종으로 검색한 경우
        imgList = imageService.searchByBreed("wrong_breed", 10);
        Assertions.assertEquals(0, imgList.size());

        // 유효한 품종으로 검색한 경우
        ImageDto randomImg = imageService.getRandomImageList(1).get(0);
        String breed = randomImg.getName();
        imgList = imageService.searchByBreed(breed, 10);
        Assertions.assertTrue(imgList.size()>0);
        Assertions.assertTrue(imgList.size()<=10);
    }

    @Test
    void searchById() throws Exception {
        // 유효하지 않은 아이디로 검색한 경우
        Assertions.assertThrows(
                ApiException.class,
                ()-> imageService.searchById("wrong_id"));

        // 유효한 아이디로 검색한 경우
        ImageDto randomImg = imageService.getRandomImageList(1).get(0);
        String id = randomImg.getId();
        ImageDetailDto imgDto = imageService.searchById(id);
        Assertions.assertEquals(randomImg.getId(), imgDto.getId());
        Assertions.assertEquals(randomImg.getUrl(), imgDto.getUrl());
        Assertions.assertEquals(randomImg.getName(), imgDto.getName());
    }
}