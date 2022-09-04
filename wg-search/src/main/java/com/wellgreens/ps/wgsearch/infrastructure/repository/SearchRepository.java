package com.wellgreens.ps.wgsearch.infrastructure.repository;

import com.wellgreens.ps.wgsearch.domain.entity.Category;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends ReactiveElasticsearchRepository<Category, Long> {

}
