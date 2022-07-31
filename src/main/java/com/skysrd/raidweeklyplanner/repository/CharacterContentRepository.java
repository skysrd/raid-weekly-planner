package com.skysrd.raidweeklyplanner.repository;

import com.skysrd.raidweeklyplanner.domain.entity.Character;
import com.skysrd.raidweeklyplanner.domain.entity.CharacterContent;
import com.skysrd.raidweeklyplanner.domain.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterContentRepository extends JpaRepository<CharacterContent, Long> {
    List<CharacterContent> findAll();
    List<CharacterContent> findByCharacter(Character character);
    List<CharacterContent> findByContent(Content content);
    Optional<CharacterContent> findByCharacterAndContent(Character character, Content content);
}
