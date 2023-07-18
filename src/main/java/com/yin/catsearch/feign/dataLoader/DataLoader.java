package com.yin.catsearch.feign.dataLoader;

import com.yin.catsearch.domain.model.ImageVo;
import com.yin.catsearch.domain.repository.ImageRepository;
import com.yin.catsearch.feign.client.BreedClient;
import com.yin.catsearch.feign.client.ImageClient;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
    private final BreedClient breedClient;
    private final ImageClient imageClient;
    private final ImageRepository imageRepository;

    private final int REQUEST_BREED_COUNT = 10;
    private final int REQUEST_IMAGE_COUNT = 10;
    private final int PAGE = 1;

    @Override
    public void run(String... args) {
        breedClient.getBreedList(REQUEST_BREED_COUNT, PAGE)
                .forEach(breedResp -> {
                    List<ImageVo> imgList = imageClient.getImageListByBreed(breedResp.id(), REQUEST_IMAGE_COUNT, 1)
                            .stream()
                            .map(imgResp ->
                                    ImageVo.builder()
                                    // image data
                                    .imageId(imgResp.id())
                                    .url(imgResp.url())
                                    .height(imgResp.height())
                                    .width(imgResp.width())
                                    // breed data
                                    .name(breedResp.name())
                                    .temperament(breedResp.temperament())
                                    .origin(breedResp.origin())
                                    .build())
                            .toList();
                    imageRepository.saveAllAndFlush(imgList);
        });
    }
}
