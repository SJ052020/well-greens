package com.wellgreens.ps.wgsearch.resolver.query;

import com.wellgreens.ps.wgsearch.domain.entity.Category;
import com.wellgreens.ps.wgsearch.domain.entity.Item;
import com.wellgreens.ps.wgsearch.domain.entity.Nutrition;
import com.wellgreens.ps.wgsearch.domain.service.SearchService;
import com.wellgreens.ps.wgsearch.domain.service.vo.CategoryWrapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SearchQuery implements GraphQLQueryResolver {

    @Autowired
    private SearchService searchService;

    public Mono<CategoryWrapper> getCategories() {
        Flux<Category> categories = searchService.getCategories();
        categories.log().subscribe();
        Item item = Item.builder()
                .id(1001L).imageUrl("test").imgAltTxt("test").name("Orange").description("This is Orange!!")
                .nutritionalInfo(Nutrition.builder().id(1002L).calories("11.3F")
                        .carbs("9.3F")
                        .fat("4.3F").protein("2.8F").build())
                .build();
        return Mono.just(CategoryWrapper.builder()
                .categories(List.of(
                        Category.builder().id(1000L).name("FRUITS").items(List.of(item)).build(),
                        Category.builder().id(2000L).name("VEGETABLES").items(List.of(item)).build()))
                .build());
    }
}
