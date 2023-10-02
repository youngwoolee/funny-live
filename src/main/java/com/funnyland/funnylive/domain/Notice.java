package com.funnyland.funnylive.domain;

import com.funnyland.funnylive.endpoint.notice.request.NoticeRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notice")
public class Notice extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author = "관리자";

    public Notice edit(NoticeRequest noticeRequest) {
        this.title = noticeRequest.getTitle();
        this.content = noticeRequest.getContent();
        return this;
    }
}
