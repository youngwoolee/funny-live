package com.funnyland.funnylive.endpoint.user.facade;

import com.funnyland.funnylive.domain.User;
import com.funnyland.funnylive.endpoint.user.request.UserRequest;
import com.funnyland.funnylive.endpoint.user.response.UserResponse;
import com.funnyland.funnylive.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    public UserResponse getUser(Long userId) {
        User findUser = userService.getUser(userId);
        return UserResponse.of(findUser);
    }

    public UserResponse createUser(UserRequest userRequest) {
        User savedUser = userService.createUser(userRequest);
        return UserResponse.of(savedUser);
    }

    public boolean checkNickName(String nickName) {
        return userService.existUser(nickName);
    }

    public boolean withdraw(Long userId) {
        userService.withdraw(userId);
        return true;
    }
}
