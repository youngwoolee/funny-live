package com.funnyland.funnylive.domain;

import java.time.LocalDateTime;

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
@Table(name = "user_account")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String grade;
    private String userName;
    private String password;
    private String email;
    private String nickName;

    private int point;
    private LocalDateTime visitedTime;
    private String relatedSNS;

    private boolean agreeReceiveEmail;
    private boolean agreeReceivePhone;

    public void deductPoints(int totalPoints) {
        this.point -= totalPoints;
    }

    public void increasePoints(int amount) {
        this.point += amount;
    }
}
