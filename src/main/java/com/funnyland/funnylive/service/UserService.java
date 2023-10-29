package com.funnyland.funnylive.service;

import com.funnyland.funnylive.domain.User;
import com.funnyland.funnylive.endpoint.user.request.UserRequest;
import com.funnyland.funnylive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(RuntimeException::new);
    }

    public boolean existUser(String nickName) {
        return userRepository.existsUserByNickName(nickName);
    }

    public User createUser(UserRequest userRequest) {
        User user = User.builder()
                .userName(userRequest.getName())
                .password(userRequest.getPassword())
                .email(userRequest.getEmail())
                .build();
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public void withdraw(Long userId) {
        User findUser = userRepository.findById(userId).orElseThrow(RuntimeException::new);
        //TODO: 포인트 내역, 및 정보 삭제
        userRepository.delete(findUser);
    }
}
