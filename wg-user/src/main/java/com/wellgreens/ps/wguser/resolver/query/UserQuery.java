package com.wellgreens.ps.wguser.resolver.query;

import com.wellgreens.ps.wguser.domain.service.UserService;
import com.wellgreens.ps.wguser.domain.service.adapter.vo.UserProfile;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    public Mono<UserProfile> userProfile(String userId) {
        return userService.getUserInfo(userId);
    }
    public Mono<String> user(String user) {
        return Mono.just(user);
    }

}
