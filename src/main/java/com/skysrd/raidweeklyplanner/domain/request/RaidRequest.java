package com.skysrd.raidweeklyplanner.domain.request;

import com.skysrd.raidweeklyplanner.domain.entity.Character;
import com.skysrd.raidweeklyplanner.domain.entity.Content;
import com.skysrd.raidweeklyplanner.domain.entity.Raid;
import com.skysrd.raidweeklyplanner.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RaidRequest {
    private Character characterId;
    private Content contentId;

    public Raid toRaid() {
        return Raid.builder()
                .character(characterId)
                .content(contentId)
                .build();
    }
}
