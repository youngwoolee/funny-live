package com.funnyland.funnylive.repository;

import java.util.Optional;

import com.funnyland.funnylive.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    boolean existsUserByNickName(String nickName);
}
