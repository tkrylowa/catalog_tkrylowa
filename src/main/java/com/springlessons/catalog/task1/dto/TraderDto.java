package com.springlessons.catalog.task1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TraderDto {
    private Long id;
    private String name;
    private String description;
    private String logo;
    @JsonProperty("site_link")
    private String siteLink;
    @JsonProperty("city_id")
    private Long cityId;
}
