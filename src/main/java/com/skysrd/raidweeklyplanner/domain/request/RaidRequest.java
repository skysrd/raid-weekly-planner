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
    private Character character;
    private Content content;

    public Raid toRaid() {
        return Raid.builder()
                .character(character)
                .content(content)
                .build();
    }
}
