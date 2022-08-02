package com.skysrd.raidweeklyplanner.auth.service;

import com.skysrd.raidweeklyplanner.auth.dto.TokenDto;
import com.skysrd.raidweeklyplanner.auth.provider.JwtTokenProvider;
import com.skysrd.raidweeklyplanner.domain.request.MemberRequest;
import com.skysrd.raidweeklyplanner.domain.request.MemberSignupRequest;
import com.skysrd.raidweeklyplanner.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Transactional
    public TokenDto login(MemberRequest memberRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = memberRequest.toAuthentication();
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return jwtTokenProvider.generateTokenDto(authentication);
    }

    @Transactional
    public Long signup(MemberSignupRequest signupRequest) {
        if(memberRepository.existsByUsername(signupRequest.getUsername())) {
            throw new IllegalArgumentException("이미 존재하는 유저입니다.");
        }
        return memberRepository.save(
                signupRequest.toMember(passwordEncoder)).getId();
    }
}
