package com.skysrd.raidweeklyplanner.domain.request;

import com.skysrd.raidweeklyplanner.domain.entity.Content;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentRequest {
    private String name;
    private int minLevel;
    private int maxLevel;
    private int reward;

    public Content toContent() {
        return Content.builder()
                .name(name)
                .minLevel(minLevel)
                .maxLevel(maxLevel)
                .reward(reward)
                .build();
    }
}
