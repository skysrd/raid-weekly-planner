package com.skysrd.raidweeklyplanner.domain.request;

import com.skysrd.raidweeklyplanner.domain.entity.Member;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MemberSignupRequest {
    private String username;
    private String password;
    private String nickname;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
