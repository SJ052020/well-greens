package com.wellgreens.ps.wgsearch.domain.service.vo;

import com.wellgreens.ps.wgsearch.domain.entity.Category;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class CategoryWrapper {
    private List<Category> categories;
}
