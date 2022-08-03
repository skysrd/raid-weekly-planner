package com.skysrd.raidweeklyplanner.domain.request;

import com.skysrd.raidweeklyplanner.domain.entity.Content;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentRequest {
    private String name;
    private Integer phase;
    private String difficulty;
    private Integer minLevel;
    private Integer maxLevel;
    private Integer reward;

    public Content toContent() {
        return Content.builder()
                .name(name)
                .phase(phase)
                .difficulty(difficulty)
                .minLevel(minLevel)
                .maxLevel(maxLevel)
                .reward(reward)
                .build();
    }
}
