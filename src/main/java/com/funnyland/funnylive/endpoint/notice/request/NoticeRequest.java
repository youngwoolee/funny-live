package com.funnyland.funnylive.endpoint.notice.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeRequest {
    private String title;
    private String content;
}