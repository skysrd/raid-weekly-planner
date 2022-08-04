package com.skysrd.raidweeklyplanner.domain.response;

import com.skysrd.raidweeklyplanner.common.enums.Authority;
import com.skysrd.raidweeklyplanner.domain.entity.Content;
import com.skysrd.raidweeklyplanner.domain.entity.Member;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
public class MemberResponse {
    private long id;
    private String username;
    private String nickname;

    @Builder
    public MemberResponse(Long id, String username, String password, String nickname, Authority authority) {
        this.id = id;
        this.username=username;
        this.nickname=nickname;
    }

    public static MemberResponse toResponse(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .username(member.getUsername())
                .nickname(member.getNickname())
                .build();
    }
}
