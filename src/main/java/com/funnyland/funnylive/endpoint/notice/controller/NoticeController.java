package com.funnyland.funnylive.endpoint.notice.controller;

import com.funnyland.funnylive.endpoint.notice.request.NoticeRequest;
import com.funnyland.funnylive.endpoint.notice.response.NoticeResponse;
import com.funnyland.funnylive.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/notices")
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping
    public Page<NoticeResponse> getNotices(Pageable pageable) {
        return noticeService.getNotices(pageable);
    }

    @GetMapping("/{noticeId}")
    public NoticeResponse getNotices(@PathVariable Long noticeId) {
        return noticeService.getNotice(noticeId);
    }

    @PostMapping
    public NoticeResponse create(@RequestBody NoticeRequest noticeRequest) {
        return noticeService.createNotice(noticeRequest);
    }

    @PutMapping("/{noticeId}")
    public NoticeResponse update(@PathVariable Long noticeId, @RequestBody NoticeRequest noticeRequest) {
        return noticeService.updateNotice(noticeId, noticeRequest);
    }

}
