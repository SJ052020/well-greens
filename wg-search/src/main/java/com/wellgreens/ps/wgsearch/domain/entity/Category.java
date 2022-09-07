package com.wellgreens.ps.wgsearch.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wellgreens.ps.wgsearch.domain.service.adapter.vo.Item;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "categories")
public class Category {
    @Id
    private Long id;
    @Field(store = true, type = FieldType.Text, fielddata = true)
    private String name;
    @Field(store = true, type = FieldType.Object, fielddata = true)
    private List<Item> items;
}
