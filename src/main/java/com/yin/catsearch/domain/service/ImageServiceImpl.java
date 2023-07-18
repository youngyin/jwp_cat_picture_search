package com.yin.catsearch.domain.service;

import com.yin.catsearch.common.exception.ApiException;
import com.yin.catsearch.common.exception.ApiStatus;
import com.yin.catsearch.domain.dto.ImageDetailDto;
import com.yin.catsearch.domain.dto.ImageDto;
import com.yin.catsearch.domain.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public List<ImageDto> getRandomImageList() {
        return imageRepository.getRandomImageList(50)
                .stream()
                .map(ImageDto::new)
                .toList();
    }

    @Override
    public List<ImageDto> searchByBreed(String breed) {
        return imageRepository.findByName(breed)
                .stream()
                .map(ImageDto::new)
                .toList();
    }

    @Override
    public ImageDetailDto searchById(String imageId) throws Exception {
         return imageRepository
                 .findById(imageId)
                 .map(ImageDetailDto::new)
                 .orElseThrow(()->new ApiException(ApiStatus.E1000));
    }
}
