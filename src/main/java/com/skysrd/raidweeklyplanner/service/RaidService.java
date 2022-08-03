package com.skysrd.raidweeklyplanner.service;

import com.skysrd.raidweeklyplanner.domain.request.RaidRequest;
import com.skysrd.raidweeklyplanner.domain.response.RaidResponse;
import com.skysrd.raidweeklyplanner.repository.CharacterRepository;
import com.skysrd.raidweeklyplanner.repository.RaidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RaidService {
    private final RaidRepository raidRepository;
    private final CharacterRepository characterRepository;
    LocalDateTime lastInitDay = LocalDateTime.of(2022, 8, 3, 6,0);
    LocalDateTime nextInitDay = lastInitDay.plusDays(7);

    public List<RaidResponse> getRaids() {
        while(LocalDateTime.now().isAfter(nextInitDay)) {
            lastInitDay=nextInitDay;
            nextInitDay.plusDays(7);
        }

        return raidRepository.findByCreatedDateBetween(lastInitDay, nextInitDay)
                .stream().map(RaidResponse::toResponse)
                .collect(Collectors.toList());
    }

    public RaidResponse getRaid(Long raidId) {
        return raidRepository.findById(raidId)
                .map(RaidResponse::toResponse)
                .orElseThrow(()->new IllegalArgumentException("Raid Not Found"));
    }

    public Long createRaid(RaidRequest raidRequest) {
        return raidRepository.save(raidRequest.toRaid()).getId();
    }

    public void deleteRaid(Long raidId) {
        raidRepository.deleteById(raidId);
    }

    public List<RaidResponse> getRaidsByCharacter(Long characterId) {
        return raidRepository.findByCharacter(
                characterRepository.findById(characterId)
                        .orElseThrow(() -> new IllegalArgumentException("Character 정보를 찾을 수 없습니다."))).stream()
                .map(RaidResponse::toResponse)
                .collect(Collectors.toList());
    }
}
