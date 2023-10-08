package com.funnyland.funnylive.endpoint.cranegame.response;

import com.funnyland.funnylive.domain.CraneGame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CraneGameResponse {

    private Long craneGameId;

    private String uuid;

    private String description;

    private String imageUrl;

    public static CraneGameResponse of(CraneGame craneGame) {
        return CraneGameResponse.builder()
                .craneGameId(craneGame.getId())
                .uuid(craneGame.getUuid())
                .description(craneGame.getDescription())
                .imageUrl(craneGame.getImageUrl())
                .build();
    }

}
