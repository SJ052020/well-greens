package com.wellgreens.ps.wgsearch.commons.exception;


import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@Component
public class GraphqlExceptionHandler {

    @ExceptionHandler({GraphQLException.class, ConstraintViolationException.class})
    public ThrowableGraphQLError handle(Exception e) {
        return new ThrowableGraphQLError(e);
    }

    @ExceptionHandler(GraphQLException.class)
    public ThrowableGraphQLError handle(RuntimeException e) {
        return new ThrowableGraphQLError(e, "Internal Server Error");
    }
}
