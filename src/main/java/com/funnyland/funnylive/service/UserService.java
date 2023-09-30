package com.funnyland.funnylive.service;

import java.util.Optional;

import com.funnyland.funnylive.domain.User;
import com.funnyland.funnylive.endpoint.user.response.UserResponse;
import com.funnyland.funnylive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse getUser(Long userId) {
        Optional<User> findUser = userRepository.findById(userId);
        return findUser.map(UserResponse::of)
                .orElseThrow(RuntimeException::new);
    }
}
