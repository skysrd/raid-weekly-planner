package com.skysrd.raidweeklyplanner.domain.response;

import com.skysrd.raidweeklyplanner.domain.entity.Character;
import com.skysrd.raidweeklyplanner.domain.entity.Content;
import com.skysrd.raidweeklyplanner.domain.entity.Member;
import com.skysrd.raidweeklyplanner.repository.MemberRepository;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
public class CharacterResponse {
    private Long id;
    private MemberResponse memberResponse;
    private String name;
    private double level;
    private String type;

    @Builder
    public CharacterResponse(Long id, Member member, String name, double level, String type) {
        this.id = id;
        this.memberResponse = MemberResponse.toResponse(member);
        this.name = name;
        this.level = level;
        this.type = type;
    }

    public static CharacterResponse toResponse(Character character) {
        return CharacterResponse.builder()
                .id(character.getId())
                .member(character.getParentMember())
                .name(character.getName())
                .level(character.getLevel())
                .type(character.getType())
                .build();
    }
}
