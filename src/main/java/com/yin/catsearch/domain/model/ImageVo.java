package com.yin.catsearch.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "MY_CAT_IMAGE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ImageVo {
    @Id
    private String imageId;

    @Column
    private String name;

    @Column
    private String url;

    @Column
    private Integer width;

    @Column
    private Integer height;

    @Column
    private String temperament;

    @Column
    private String origin;
}
