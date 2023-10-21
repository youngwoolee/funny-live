package com.funnyland.funnylive.domain;

import com.funnyland.funnylive.endpoint.cranegame.request.Position;
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
@Table(name = "crane_game")
public class CraneGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private String description;

    private String imageUrl;

    //TODO: 크레인용 상품?

    private int playFee;

    private Integer answerX; // 정답 x 좌표
    private Integer answerY; // 정답 y 좌표

    public boolean play(Position position) {
        return position.getX().equals(answerX) && position.getY().equals(answerY);
    }
}
