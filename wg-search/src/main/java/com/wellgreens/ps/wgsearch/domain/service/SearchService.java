package com.wellgreens.ps.wgsearch.domain.service;

import com.wellgreens.ps.wgsearch.domain.entity.Category;
import com.wellgreens.ps.wgsearch.infrastructure.service.SearchDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class SearchService {

    @Autowired
    private SearchDataService searchDataService;

    public Flux<Category> getCategories() {
        return searchDataService.getAllCategories();
    }

}
