package com.wellgreens.ps.wgsearch.infrastructure.service;

import com.wellgreens.ps.wgsearch.commons.exception.NotFoundException;
import com.wellgreens.ps.wgsearch.domain.entity.Category;
import com.wellgreens.ps.wgsearch.infrastructure.repository.SearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
@Slf4j
public class SearchDataService {

    @Autowired
    private SearchRepository searchRepository;

    public Flux<Category> getAllCategories() {
        return searchRepository
                .findAll()
                .timeout(Duration.ofSeconds(3))
                .onErrorMap(throwable -> {
                    log.error("Error occurred while fetching data from ElasticSearch : {}", throwable.getMessage());
                    throw new NotFoundException("Data Not Found");
                });
    }

}
