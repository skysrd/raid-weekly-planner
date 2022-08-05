package com.skysrd.raidweeklyplanner.domain.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.skysrd.raidweeklyplanner.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member_group")
public class MemberGroup extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_group_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "group_id")
    private Group group;

    @Builder
    public MemberGroup(Member member, Group group) {
        this.member = member;
        this.group = group;
    }
}
