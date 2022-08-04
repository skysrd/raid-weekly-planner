package com.skysrd.raidweeklyplanner.domain.response;

import com.skysrd.raidweeklyplanner.domain.entity.Content;
import com.skysrd.raidweeklyplanner.domain.request.ContentRequest;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContentResponse {
    private Long id;
    private String name;
    private Integer phase;
    private String difficulty;
    private Integer minLevel;
    private Integer maxLevel;
    private Integer reward;

    @Builder
    public ContentResponse(Long id, String name, Integer phase, String difficulty, int minLevel, int maxLevel, int reward) {
        this.id = id;
        this.name = name;
        this.phase = phase;
        this.difficulty = difficulty;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.reward = reward;
    }

    public static ContentResponse toResponse(Content content) {
        return ContentResponse.builder()
                .id(content.getId())
                .name(content.getName())
                .phase(content.getPhase())
                .difficulty(content.getDifficulty())
                .minLevel(content.getMinLevel())
                .maxLevel(content.getMaxLevel())
                .reward(content.getReward())
                .build();
    }
}
