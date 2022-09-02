package com.wellgreens.ps.wguser.domain.service;

import com.wellgreens.ps.wguser.domain.entity.User;
import com.wellgreens.ps.wguser.domain.service.adapter.vo.UserProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserService {
    public Mono<UserProfile> getUserInfo(String userId) {
        UserProfile userProfile =new UserProfile();
        userProfile.setUserId(userId);
        return Mono.just(userProfile);
    }
}
