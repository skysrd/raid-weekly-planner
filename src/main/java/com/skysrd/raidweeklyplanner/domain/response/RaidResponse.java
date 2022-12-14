package com.skysrd.raidweeklyplanner.domain.response;

import com.skysrd.raidweeklyplanner.domain.entity.Character;
import com.skysrd.raidweeklyplanner.domain.entity.Content;
import com.skysrd.raidweeklyplanner.domain.entity.Raid;
import com.skysrd.raidweeklyplanner.service.RaidService;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
public class RaidResponse {
    private Long id;
    private CharacterResponse character;
    private ContentResponse content;
    private Boolean status;

    @Builder
    public RaidResponse(Long id, CharacterResponse character, ContentResponse content, Boolean status) {
        this.id=id;
        this.character=character;
        this.content=content;
        this.status=status;
    }

    public static RaidResponse toResponse(Raid raid) {
        return RaidResponse.builder()
                .id(raid.getId())
                .character(CharacterResponse.toResponse(raid.getCharacter()))
                .content(ContentResponse.toResponse(raid.getContent()))
                .status(raid.getStatus())
                .build();
    }
}
