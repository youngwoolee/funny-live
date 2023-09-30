package com.funnyland.funnylive.endpoint.user.controller;

import com.funnyland.funnylive.endpoint.user.response.UserResponse;
import com.funnyland.funnylive.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

}
