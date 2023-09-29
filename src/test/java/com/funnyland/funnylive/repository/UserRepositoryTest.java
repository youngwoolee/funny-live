package com.funnyland.funnylive.repository;

import java.util.Optional;

import com.funnyland.funnylive.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.yml")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void 유저_저장_성공() {
        User user = User.builder()
                .username("퍼니1")
                .password("퍼니1")
                .email("funny@gmail.com")
                .point(0).build();

        User savedUser = userRepository.save(user);

        Assertions.assertEquals(user.getId(), savedUser.getId());
        Assertions.assertEquals(user.getUsername(), savedUser.getUsername());
    }

    @Test
    void 유저_조회_실패() {
        User user = User.builder()
                .username("퍼니1")
                .password("퍼니1")
                .email("funny@gmail.com")
                .point(0).build();

        User savedUser = userRepository.save(user);

        Optional<User> findUser = userRepository.findById(2L);

        Assertions.assertNotEquals(savedUser.getId(), findUser.map(User::getId)
                .orElse(null));
        Assertions.assertNull(findUser.map(User::getId)
                .orElse(null));
    }

    @Test
    void 유저_조회_성공() {
        User user = User.builder()
                .username("퍼니1")
                .password("퍼니1")
                .email("funny@gmail.com")
                .point(0).build();

        User savedUser = userRepository.save(user);

        Optional<User> findUser = userRepository.findById(user.getId());

        Assertions.assertEquals(savedUser.getId(), findUser.map(User::getId)
                .orElse(null));
    }
}