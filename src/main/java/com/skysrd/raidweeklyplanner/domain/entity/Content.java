package com.skysrd.raidweeklyplanner.domain.entity;

import com.skysrd.raidweeklyplanner.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CONTENT")
public class Content extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long id;

    @Column(name = "content_name")
    private String name;

    @Column(name = "content_min_level")
    private int minLevel;

    @Column(name = "content_max_level")
    private int maxLevel;

    @Column(name = "content_reward")
    private int reward;

    @Builder
    public Content(String name, int minLevel, int maxLevel, int reward) {
        this.name = name;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.reward = reward;
    }

    public void updateContent(String name, int minLevel, int maxLevel, int reward) {
        this.name=name;
        this.minLevel=minLevel;
        this.maxLevel=maxLevel;
        this.reward=reward;
    }
}
