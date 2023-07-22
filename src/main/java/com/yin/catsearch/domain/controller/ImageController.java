package com.yin.catsearch.domain.controller;

import com.yin.catsearch.domain.dto.ImageDetailDto;
import com.yin.catsearch.domain.dto.ImageDto;
import com.yin.catsearch.common.dto.ApiDataListResponse;
import com.yin.catsearch.common.dto.ApiDataResponse;
import com.yin.catsearch.domain.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cats")
public class ImageController {
    private final ImageService catImageService;

    @GetMapping("/random50")
    public ResponseEntity<ApiDataListResponse<ImageDto>> getRandomImages() {
        return ResponseEntity.ok(new ApiDataListResponse<>(catImageService.getRandomImageList(50)));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiDataListResponse<ImageDto>> searchByBreed(@RequestParam("q") String breed) {
        return ResponseEntity.ok(new ApiDataListResponse<>(catImageService.searchByBreed(breed, 100)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<ImageDetailDto>> searchById(@PathVariable("id") String catImageId) throws Exception {
        return ResponseEntity.ok(new ApiDataResponse<>(catImageService.searchById(catImageId)));
    }
}
