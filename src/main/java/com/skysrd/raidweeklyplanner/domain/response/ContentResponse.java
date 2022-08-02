package com.skysrd.raidweeklyplanner.domain.response;

import com.skysrd.raidweeklyplanner.domain.entity.Content;
import com.skysrd.raidweeklyplanner.domain.request.ContentRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ContentResponse {
    private Long id;
    private String name;
    private int minLevel;
    private int maxLevel;
    private int reward;

    @Builder
    public ContentResponse(Long id, String name, int minLevel, int maxLevel, int reward) {
        this.id = id;
        this.name = name;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.reward = reward;
    }

    public static ContentResponse toResponse(Content content) {
        return ContentResponse.builder()
                .id(content.getId())
                .name(content.getName())
                .minLevel(content.getMinLevel())
                .maxLevel(content.getMaxLevel())
                .reward(content.getReward())
                .build();
    }
}
