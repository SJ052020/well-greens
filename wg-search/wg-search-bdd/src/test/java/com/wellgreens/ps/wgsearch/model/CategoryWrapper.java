package com.wellgreens.ps.wgsearch.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryWrapper {
    private List<Category> categories;
}
