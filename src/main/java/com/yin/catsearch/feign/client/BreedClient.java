package com.yin.catsearch.feign.client;

import com.yin.catsearch.feign.dto.BreedResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "BreedClient", url = "https://api.thecatapi.com/v1")
public interface BreedClient {
    @GetMapping("/breeds")
    List<BreedResponse> getBreedList(@RequestParam("limit") int limit);
}
