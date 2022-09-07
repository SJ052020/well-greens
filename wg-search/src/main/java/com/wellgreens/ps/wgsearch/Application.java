package com.wellgreens.ps.wgsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableReactiveElasticsearchRepositories
@CrossOrigin
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
