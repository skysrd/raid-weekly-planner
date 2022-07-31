package com.skysrd.raidweeklyplanner.repository;

import com.skysrd.raidweeklyplanner.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAll();
    Optional<Member> findById(Long id);
    Optional<Member> findByUsername(String username);

    boolean existsByUsername(String username);
}
