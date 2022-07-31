package com.skysrd.raidweeklyplanner.repository;

import com.skysrd.raidweeklyplanner.domain.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {
    List<Content> findAll();
    Optional<Content> findById(Long id);
    Optional<Content> findByName(String name);
}
