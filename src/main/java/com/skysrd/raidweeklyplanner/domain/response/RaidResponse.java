package com.skysrd.raidweeklyplanner.domain.response;

import com.skysrd.raidweeklyplanner.domain.entity.Character;
import com.skysrd.raidweeklyplanner.domain.entity.Content;
import com.skysrd.raidweeklyplanner.domain.entity.Raid;
import com.skysrd.raidweeklyplanner.service.RaidService;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RaidResponse {
    private Long id;
    private Character character;
    private Content content;
    private Boolean status;

    @Builder
    public RaidResponse(Long id, Character character, Content content, Boolean status) {
        this.id=id;
        this.character=character;
        this.content=content;
        this.status=status;
    }

    public static RaidResponse toResponse(Raid raid) {
        return RaidResponse.builder()
                .id(raid.getId())
                .character(raid.getCharacter())
                .content(raid.getContent())
                .status(raid.getStatus())
                .build();
    }
}
