package com.funnyland.funnylive.endpoint.notice.response;

import com.funnyland.funnylive.domain.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class NoticeResponse {

    private Long noticeId;
    private String title;
    private String content;
    private String author;

    public static NoticeResponse of(Notice notice) {
        return NoticeResponse.builder()
                .noticeId(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .author(notice.getAuthor())
                .build();
    }

}
