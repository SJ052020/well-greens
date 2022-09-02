package com.wellgreens.ps.wguser.resolver.mutation;

import com.wellgreens.ps.wguser.domain.entity.User;
import com.wellgreens.ps.wguser.domain.service.adapter.vo.UpdateResponse;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserMutation implements GraphQLMutationResolver {

    public Mono<UpdateResponse> updateUserProfile(User user) {
        return Mono.empty();
    }
}
