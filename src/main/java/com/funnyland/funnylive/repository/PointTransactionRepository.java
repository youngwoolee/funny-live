package com.funnyland.funnylive.repository;

import com.funnyland.funnylive.domain.PointTransaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PointTransactionRepository extends JpaRepository<PointTransaction, Long> {
}
