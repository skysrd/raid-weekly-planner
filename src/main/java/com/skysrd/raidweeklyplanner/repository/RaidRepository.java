package com.skysrd.raidweeklyplanner.repository;

import com.skysrd.raidweeklyplanner.domain.entity.Character;
import com.skysrd.raidweeklyplanner.domain.entity.Raid;
import com.skysrd.raidweeklyplanner.domain.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RaidRepository extends JpaRepository<Raid, Long> {
    List<Raid> findAll();
    List<Raid> findByCreatedDateBetween(LocalDateTime start, LocalDateTime end);
    List<Raid> findByCharacter(Character character);
    List<Raid> findByContent(Content content);
    Optional<Raid> findByCharacterAndContent(Character character, Content content);
}
