package com.wellgreens.ps.wgsearch.domain.service.adapter.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Dynamic;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "items")
@ToString
public class Item {
    @Id
    private Long id;
    @Field(store = true, type = FieldType.Text, dynamic = Dynamic.TRUE)
    private String name;
    @Field(store = true, type = FieldType.Text, fielddata = true)
    private String imageUrl;
    @Field(store = true, type = FieldType.Text, fielddata = true)
    private String imgAltTxt;
    @Field(store = true, type = FieldType.Text, fielddata = true)
    private String description;
    @Field(store = true, type = FieldType.Object, fielddata = true)
    private Nutrition nutritionalInfo;
}
