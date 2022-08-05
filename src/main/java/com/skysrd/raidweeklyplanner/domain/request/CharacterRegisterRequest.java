package com.skysrd.raidweeklyplanner.domain.request;

import com.skysrd.raidweeklyplanner.domain.entity.Character;
import com.skysrd.raidweeklyplanner.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterRegisterRequest {
    private Member parentMember;
    private String name;
    private double level;
    private String type;

    public Character toCharacter() {
        return Character.builder()
                .parentMember(parentMember)
                .name(name)
                .level(level)
                .type(type)
                .build();
    }
}
