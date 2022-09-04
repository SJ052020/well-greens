package com.wellgreens.ps.wgsearch.commons.bootstrap;

import com.wellgreens.ps.wgsearch.domain.entity.Category;
import com.wellgreens.ps.wgsearch.domain.entity.Item;
import com.wellgreens.ps.wgsearch.domain.enums.CategoryName;
import com.wellgreens.ps.wgsearch.infrastructure.repository.SearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private SearchRepository repository;
    //public DataInitializer(SearchRepository repository) {
    //    this.repository = repository;
    //}

    private List<Item> items = new ArrayList<>();
    @Override
    public void run(String... args) throws Exception {
      log.info("Start data initialization....");
      Item item = Item.builder()
              .id(1001L).imageUrl("test").imgAltTxt("test").name("Orange").description("This is Orange!!").build();
      repository
              .deleteAll()
              .thenMany(Flux.just(Category.builder().id(1000L).name("FRUITS").items(List.of(item)).build(),
                      Category.builder().id(2000L).name("VEGETABLES").items(List.of(item)).build()))
              .flatMap(category -> repository.save(category))
              .log()
              .subscribe(null, null, () -> log.info("Data initialization done"));

    }
}
