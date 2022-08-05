package com.skysrd.raidweeklyplanner.domain.response;

import com.skysrd.raidweeklyplanner.domain.entity.MemberGroup;
import lombok.Builder;

import java.time.LocalDateTime;

public class MemberGroupResponse {
    private Long id;
    private MemberResponse memberResponse;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    @Builder
    public MemberGroupResponse(Long id, MemberResponse memberResponse, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.memberResponse = memberResponse;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public static MemberGroupResponse toResponse(MemberGroup memberGroup) {
        return MemberGroupResponse.builder()
                .id(memberGroup.getId())
                .memberResponse(MemberResponse.toResponse(memberGroup.getMember()))
                .createdDate(memberGroup.getCreatedDate())
                .lastModifiedDate(memberGroup.getLastModifiedDate())
                .build();
    }
}
