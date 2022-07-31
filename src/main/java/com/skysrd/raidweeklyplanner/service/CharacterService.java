package com.skysrd.raidweeklyplanner.service;

import com.skysrd.raidweeklyplanner.domain.entity.Character;
import com.skysrd.raidweeklyplanner.domain.request.CharacterRegisterRequest;
import com.skysrd.raidweeklyplanner.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CharacterService {
    CharacterRepository characterRepository;

    public Character registerCharacter(CharacterRegisterRequest characterRegisterRequest) {
        return characterRepository.save()
    }

    public List<Character> getCharacters() {
        return characterRepository.findAll();
    }
}
