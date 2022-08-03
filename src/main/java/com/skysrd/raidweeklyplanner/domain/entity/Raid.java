package com.skysrd.raidweeklyplanner.domain.entity;

import com.skysrd.raidweeklyplanner.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "CHARACTER_CONTENT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Raid extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_content_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id")
    private Character character;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    private Content content;

    @Column(name = "is_done")
    private Boolean status;

    @Builder
    public Raid(Character character, Content content) {
        this.character = character;
        this.content = content;
        this.status = true;
    }
}
