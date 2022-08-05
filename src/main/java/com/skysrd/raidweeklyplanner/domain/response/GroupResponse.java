package com.skysrd.raidweeklyplanner.domain.response;

import com.skysrd.raidweeklyplanner.domain.entity.Group;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GroupResponse {
    private Long id;
    private String name;

    @Builder
    public GroupResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static GroupResponse toResponse(Group group) {
        return GroupResponse.builder()
                .id(group.getId())
                .name(group.getName())
                .build();
    }
}
