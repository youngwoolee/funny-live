package com.funnyland.funnylive.repository;

import java.util.Optional;

import com.funnyland.funnylive.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);
}
