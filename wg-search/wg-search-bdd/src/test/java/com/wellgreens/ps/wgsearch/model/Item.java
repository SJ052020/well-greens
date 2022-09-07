package com.wellgreens.ps.wgsearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Item {
    private Long id;
    private String name;
    private String imageUrl;
    private String imgAltTxt;
    private String description;
    private Nutrition nutritionalInfo;
}
