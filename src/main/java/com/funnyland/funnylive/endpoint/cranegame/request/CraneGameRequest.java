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
    private Integer answerX;
    private Integer answerY;

    public CraneGame toDomain() {
        CraneGame craneGame = CraneGame.builder()
                .uuid(this.uuid)
                .description(this.description)
                .imageUrl(this.imageUrl)
                .answerX(this.answerX)
                .answerY(this.answerY)
                .build();
        return craneGame;
    }
}
