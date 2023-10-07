package com.funnyland.funnylive.repository;

import java.util.List;

import com.funnyland.funnylive.domain.PointTransaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PointTransactionRepository extends JpaRepository<PointTransaction, Long> {

    List<PointTransaction> findAllByUserId(Long userId);
}
