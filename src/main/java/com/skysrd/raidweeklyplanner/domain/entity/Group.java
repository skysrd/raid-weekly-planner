package com.skysrd.raidweeklyplanner.domain.entity;

import com.skysrd.raidweeklyplanner.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.executable.ValidateOnExecution;

@Getter
@Entity
@Table(name = "GROUP")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Group extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    @Column(name = "group_name")
    private String name;

    @Builder
    public Group(String name) {
        this.name = name;
    }
}
