package com.funnyland.funnylive.endpoint.user.response;

import com.funnyland.funnylive.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserResponse {

    private Long userId;
    private String userName;
    private String email;
    private int point;

    public static UserResponse of(User user) {
        return UserResponse.builder()
                .userId(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .point(user.getPoint())
                .build();
    }

}
