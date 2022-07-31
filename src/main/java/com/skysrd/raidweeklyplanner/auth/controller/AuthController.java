package com.skysrd.raidweeklyplanner.auth.controller;

import com.skysrd.raidweeklyplanner.auth.service.AuthService;
import com.skysrd.raidweeklyplanner.domain.request.MemberRequest;
import com.skysrd.raidweeklyplanner.domain.request.MemberSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody MemberSignupRequest signupRequest) {
        return ResponseEntity.ok(authService.signup(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberRequest memberRequest) {
        return ResponseEntity.ok(authService.login(memberRequest));
    }

//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(@RequestBody MemberRequest memberRequest) {
//        return ResponseEntity.ok(authService.logout(memberRequest));
//    }
}
