package com.skysrd.raidweeklyplanner.domain.response;

import com.skysrd.raidweeklyplanner.domain.entity.Group;
import com.skysrd.raidweeklyplanner.domain.entity.MemberGroup;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class GroupDetailResponse {
    private Long id;
    private String name;
    private List<MemberResponse> memberResponseList;

    @Builder
    public GroupDetailResponse(Long id, String name, List<MemberResponse> memberResponseList) {
        this.id = id;
        this.name = name;
        this.memberResponseList = memberResponseList;
    }

    public static GroupDetailResponse toResponse(Group group, List<MemberGroup> memberGroupList) {

        return GroupDetailResponse.builder()
                .id(group.getId())
                .name(group.getName())
                .memberResponseList(
                        memberGroupList.stream()
                                .map(MemberGroup::getMember)
                                .collect(Collectors.toList())
                                .stream()
                                .map(MemberResponse::toResponse)
                                .collect(Collectors.toList()))
                .build();
    }
}
