package com.wellgreens.ps.wgsearch.resolver.query;

import com.wellgreens.ps.wgsearch.domain.service.SearchService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SearchQuery implements GraphQLQueryResolver {

    @Autowired
    private SearchService userService;


}
