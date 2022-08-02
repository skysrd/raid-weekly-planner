package com.skysrd.raidweeklyplanner.service;

import com.skysrd.raidweeklyplanner.domain.request.CharacterRegisterRequest;
import com.skysrd.raidweeklyplanner.domain.response.CharacterResponse;
import com.skysrd.raidweeklyplanner.repository.CharacterRepository;
import com.skysrd.raidweeklyplanner.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.TransactionScoped;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CharacterService {
    private final CharacterRepository characterRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long register(CharacterRegisterRequest characterRegisterRequest) {
        return characterRepository.save(characterRegisterRequest.toCharacter()).getId();
    }

    public List<CharacterResponse> getCharacters() {
        return characterRepository.findAll().stream()
                .map(CharacterResponse::toResponse)
                .collect(Collectors.toList());
    }

    public List<CharacterResponse> getCharacterByUsername(String username) {
        return characterRepository.findByParentMember(
                memberRepository.findByUsername(username)
                        .orElseThrow(()->new IllegalArgumentException("Character Not Found")))
                .stream().map(CharacterResponse::toResponse)
                .collect(Collectors.toList());
    }
}
