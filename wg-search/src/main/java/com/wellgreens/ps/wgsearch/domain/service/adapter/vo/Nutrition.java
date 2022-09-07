package com.wellgreens.ps.wgsearch.domain.service.adapter.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Document(indexName = "nutritionalInfo")
public class Nutrition {
    @Id
    private Long id;
    @Field(store = true, type = FieldType.Text, fielddata = true)
    private String calories;
    @Field(store = true, type = FieldType.Text, fielddata = true)
    private String carbs;
    @Field(store = true, type = FieldType.Text, fielddata = true)
    private String fat;
    @Field(store = true, type = FieldType.Text, fielddata = true)
    private String protein;
}
