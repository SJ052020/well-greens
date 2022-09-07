package com.wellgreens.ps.wgsearch.commons.bootstrap;

import com.wellgreens.ps.wgsearch.domain.service.adapter.vo.Item;
import com.wellgreens.ps.wgsearch.infrastructure.repository.SearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private SearchRepository repository;

    private List<Item> items = new ArrayList<>();
    @Override
    public void run(String... args) throws Exception {
        log.info("Start data initialization....");
        repository
                .deleteAll()
                .log()
                .subscribe(null, null, () -> log.info("Data cleared"));

    }
}
