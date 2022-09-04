package com.wellgreens.ps.wgsearch.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "categories")
@ToString
public class Category {
    @Id
    private Long id;
    @Field(store = true, type = FieldType.Text, fielddata = true)
    private String name;
    @Field(store = true, type = FieldType.Auto, fielddata = true)
    private List<Item> items;
}
