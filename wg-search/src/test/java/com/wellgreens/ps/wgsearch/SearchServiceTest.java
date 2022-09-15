package com.wellgreens.ps.wgsearch;

import com.wellgreens.ps.wgsearch.domain.entity.Category;
import com.wellgreens.ps.wgsearch.domain.service.SearchService;
import com.wellgreens.ps.wgsearch.domain.service.adapter.vo.Item;
import com.wellgreens.ps.wgsearch.domain.service.adapter.vo.Nutrition;
import com.wellgreens.ps.wgsearch.infrastructure.repository.SearchRepository;
import com.wellgreens.ps.wgsearch.infrastructure.service.SearchDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebFlux;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.mockito.Mockito.when;


@WebFluxTest(SearchService.class)
@ExtendWith(SpringExtension.class)
class SearchServiceTest {

    @Autowired
    private SearchService searchService;

    @MockBean
    private SearchDataService searchDataService;

    @Test
    public void getCategoriesTest() {

        Item item = Item.builder()
                .id(1001L)
                .imageUrl("test")
                .imgAltTxt("test")
                .name("Orange")
                .description("This is Orange!!")
                .nutritionalInfo(
                        Nutrition.builder()
                                .id(1002L)
                                .calories("11.3F")
                                .carbs("9.3F")
                                .fat("4.3F")
                                .protein("2.8F")
                                .build())
                .build();

        Category category = Category.builder().id(1000L).name("FRUITS").items(List.of(item)).build();

        Flux<Category> categoryFlux = Flux.just(category);

        when(searchDataService.getAllCategories()).thenReturn(categoryFlux);

        Flux<Category> categoryFluxResponse = searchService.getCategories();
        Assertions.assertNotNull(categoryFluxResponse.blockFirst());
        Assertions.assertEquals(categoryFluxResponse.blockFirst(), categoryFlux.blockFirst());
    }

}
