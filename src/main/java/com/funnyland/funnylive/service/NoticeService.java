package com.funnyland.funnylive.service;

import com.funnyland.funnylive.domain.Notice;
import com.funnyland.funnylive.endpoint.notice.request.NoticeRequest;
import com.funnyland.funnylive.endpoint.notice.response.NoticeResponse;
import com.funnyland.funnylive.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public Page<NoticeResponse> getNotices(Pageable pageable) {
        Page<Notice> notices = noticeRepository.findAll(pageable);
        return notices.map(NoticeResponse::of);
    }

    public NoticeResponse getNotice(Long noticeId) {
        return noticeRepository.findById(noticeId)
                .map(NoticeResponse::of)
                .orElseThrow(() -> new RuntimeException("notice not exist"));
    }

    public NoticeResponse createNotice(NoticeRequest noticeRequest) {
        Notice notice = Notice.builder()
                .title(noticeRequest.getTitle())
                .content(noticeRequest.getContent())
                .author("관리자")
                .build();
        Notice savedNotice = noticeRepository.save(notice);
        return NoticeResponse.of(savedNotice);
    }

    @Transactional
    public NoticeResponse updateNotice(Long noticeId, NoticeRequest noticeRequest) {
        return noticeRepository.findById(noticeId)
                .map(notice -> notice.edit(noticeRequest))
                .map(NoticeResponse::of)
                .orElseThrow(() -> new RuntimeException("notice not exist"));
    }
}
