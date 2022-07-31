package com.skysrd.raidweeklyplanner.repository;

import com.skysrd.raidweeklyplanner.domain.entity.Character;
import com.skysrd.raidweeklyplanner.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findAll();
    Optional<Character> findById(Long id);
    Optional<Character> findByName(String name);
    List<Character> findByParentMember(Member member);
}
