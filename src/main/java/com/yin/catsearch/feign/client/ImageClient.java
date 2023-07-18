package com.yin.catsearch.feign.client;

import com.yin.catsearch.feign.config.FeignClientConfig;
import com.yin.catsearch.feign.dto.ImageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ImageClient", url = "${cat-api.url}", configuration = FeignClientConfig.class)
public interface ImageClient {

    @GetMapping("/images/search")
    List<ImageResponse> getRandomImages(
            @RequestParam("limit") int limit,
            @RequestParam("page") int page);

    @GetMapping("/images/search")
    List<ImageResponse> getImageListByBreed(
            @RequestParam("breed_ids") String breedId,
            @RequestParam("limit") int limit,
            @RequestParam("page") int page);

    @GetMapping("/images/{imageId}")
    ImageResponse getImageById(@PathVariable("imageId") String imageId);
}
