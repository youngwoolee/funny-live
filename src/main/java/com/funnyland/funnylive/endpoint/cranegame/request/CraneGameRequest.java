package com.funnyland.funnylive.endpoint.cranegame.request;

import com.funnyland.funnylive.domain.CraneGame;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CraneGameRequest {

    private String uuid;
    private String description;
    private String imageUrl;

    public CraneGame toDomain() {
        CraneGame craneGame = CraneGame.builder()
                .uuid(this.uuid)
                .description(this.description)
                .imageUrl(this.imageUrl)
                .build();
        return craneGame;
    }
}
