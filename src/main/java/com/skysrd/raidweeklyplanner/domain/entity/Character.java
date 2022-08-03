package com.skysrd.raidweeklyplanner.domain.entity;

import com.skysrd.raidweeklyplanner.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "CHARACTERS")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Character extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member parentMember;

    @Column(name = "character_name")
    private String name;

    @Column(name = "character_level")
    private Double level;

    @Column(name = "character_type")
    private String type;

    @Builder
    public Character(Member parentMember, String name, double level, String type) {
        this.parentMember=parentMember;
        this.name=name;
        this.level=level;
        this.type=type;
    }

    public static void nameChange(Character character, String name) {
        character.name=name;
    }

    public static void levelChange(Character character, double level) {
        character.level=level;
    }

    public static void typeChange(Character character, String type) {
        character.type=type;
    }
}

