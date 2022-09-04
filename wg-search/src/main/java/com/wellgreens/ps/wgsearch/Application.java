package com.wellgreens.ps.wgsearch;

import com.fasterxml.jackson.annotation.JsonInclude;
import graphql.kickstart.execution.GraphQLObjectMapper;
import graphql.kickstart.execution.config.GraphQLServletObjectMapperConfigurer;
import graphql.kickstart.execution.config.ObjectMapperProvider;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import graphql.kickstart.spring.error.ErrorHandlerSupplier;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

@SpringBootApplication
@EnableReactiveElasticsearchRepositories
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public GraphQLObjectMapper graphQLObjectMapper(ObjectProvider<ObjectMapperProvider> objectMapperProviderObjectProvider,
												   @Autowired GraphQLErrorHandler graphQLExceptionHandler,
												   @Autowired(required = false) GraphQLServletObjectMapperConfigurer objectMapperConfigurer) {
		GraphQLObjectMapper.Builder builder = GraphQLObjectMapper.newBuilder();
		builder.withGraphQLErrorHandler(new ErrorHandlerSupplier(graphQLExceptionHandler));
		ObjectMapperProvider objectMapperProvider = objectMapperProviderObjectProvider.getIfAvailable();
		if (objectMapperProvider != null) {
			builder.withObjectMapperProvider(objectMapperProvider);
		} else if (objectMapperConfigurer != null) {
			builder.withObjectMapperConfigurer(objectMapperConfigurer);
		}
		GraphQLObjectMapper graphQLObjectMapper = builder.build();
		graphQLObjectMapper.getJacksonMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return graphQLObjectMapper;

	}

}
