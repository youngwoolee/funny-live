package com.funnyland.funnylive.endpoint.user.controller;

import com.funnyland.funnylive.endpoint.user.facade.UserFacade;
import com.funnyland.funnylive.endpoint.user.request.UserRequest;
import com.funnyland.funnylive.endpoint.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserFacade userFacade;

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        return userFacade.getUser(userId);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userFacade.createUser(userRequest);
    }

    @PostMapping("/check")
    public boolean checkUserName(@RequestParam String nickName) {
        return userFacade.checkNickName(nickName);
    }

    @DeleteMapping("/{userId}")
    public boolean withdraw(@PathVariable Long userId) {
        return userFacade.withdraw(userId);
    }

    //TODO: 로그인 시 방문일시 업데이트
}