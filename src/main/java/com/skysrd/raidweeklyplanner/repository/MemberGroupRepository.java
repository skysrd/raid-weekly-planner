package com.skysrd.raidweeklyplanner.repository;

import com.skysrd.raidweeklyplanner.domain.entity.Group;
import com.skysrd.raidweeklyplanner.domain.entity.MemberGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberGroupRepository extends JpaRepository<MemberGroup, Long> {
    List<MemberGroup> findAllByGroup(Group group);
}
