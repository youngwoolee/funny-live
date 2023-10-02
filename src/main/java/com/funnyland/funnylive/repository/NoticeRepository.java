package com.funnyland.funnylive.repository;

import com.funnyland.funnylive.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
