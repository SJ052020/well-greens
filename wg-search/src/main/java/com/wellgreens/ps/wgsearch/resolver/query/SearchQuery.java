package com.wellgreens.ps.wgsearch.resolver.query;

import com.wellgreens.ps.wgsearch.domain.service.SearchService;
import com.wellgreens.ps.wgsearch.domain.service.vo.CategoryWrapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class SearchQuery implements GraphQLQueryResolver {

    @Autowired
    private SearchService searchService;

    public Mono<CategoryWrapper> getCategories() {
        return searchService
                .getCategories()
                .collectList()
                .map(categories1 ->
                        CategoryWrapper.builder()
                                .categories(categories1)
                                .build()
                );

    }
}
