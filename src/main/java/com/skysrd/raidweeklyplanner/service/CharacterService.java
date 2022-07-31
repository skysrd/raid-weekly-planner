package com.skysrd.raidweeklyplanner.service;

import com.skysrd.raidweeklyplanner.domain.entity.Character;
import com.skysrd.raidweeklyplanner.domain.request.CharacterRegisterRequest;
import com.skysrd.raidweeklyplanner.repository.CharacterRepository;
import com.skysrd.raidweeklyplanner.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CharacterService {
    CharacterRepository characterRepository;
    MemberRepository memberRepository;

    public Character register(CharacterRegisterRequest characterRegisterRequest) {
        return characterRepository.save(characterRegisterRequest.toCharacter());
    }

    public List<Character> getCharacters() {
        return characterRepository.findAll();
    }

    public List<Character> getCharacterByUsername(String username) {
        return characterRepository.findByParentMember(
                memberRepository.findByUsername(username)
                        .orElseThrow(()-> new UsernameNotFoundException("사용자 이름을 찾을 수 없습니다.")));
    }
}
