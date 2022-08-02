package com.skysrd.raidweeklyplanner.controller;

import com.skysrd.raidweeklyplanner.domain.request.CharacterRegisterRequest;
import com.skysrd.raidweeklyplanner.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CharacterRegisterRequest characterRegisterRequest) {
        return ResponseEntity.ok(characterService.register(characterRegisterRequest));
    }

    @GetMapping("/")
    public ResponseEntity<?> getCharacters() {
        return ResponseEntity.ok(characterService.getCharacters());
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getCharactersByUsername(@PathVariable String username) {
        return ResponseEntity.ok(characterService.getCharacterByUsername(username));
    }
}
