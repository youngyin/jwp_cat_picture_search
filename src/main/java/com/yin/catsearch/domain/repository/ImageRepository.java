package com.yin.catsearch.domain.repository;

import com.yin.catsearch.domain.model.ImageVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageVo, String> {
    @Query(value = "SELECT * FROM my_cat_image ORDER BY RAND() LIMIT ?1", nativeQuery = true)
    List<ImageVo> getRandomImageList(int limit);

    List<ImageVo> findByName(@Param("name") String name);
}
