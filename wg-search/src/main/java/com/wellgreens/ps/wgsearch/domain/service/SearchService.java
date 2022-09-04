package com.wellgreens.ps.wgsearch.domain.service;

import com.wellgreens.ps.wgsearch.domain.entity.Category;
import com.wellgreens.ps.wgsearch.infrastructure.repository.SearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;
    public Flux<Category> getCategories() {
        return searchRepository.findAll();
    }

    //public Mono<Category> getByCategoryId(Long categoryId) {
    //    return searchRepository.findById(categoryId);
    //}
}
