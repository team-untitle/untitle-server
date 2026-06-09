package com.team.moodit.domain.auth;

import com.team.moodit.domain.User;
import com.team.moodit.domain.UserAuthIdentityFinder;
import com.team.moodit.domain.UserManager;
import com.team.moodit.domain.UserReader;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SocialLoginHandler {
    private final UserAuthIdentityFinder userAuthIdentityFinder;
    private final UserReader userReader;
    private final UserManager userManager;

    public AuthUser loginOrSignup(SocialProfile profile) {
        Long userId = Optional.ofNullable(
                userAuthIdentityFinder.findUserIdOrNull(profile.getProvider(), profile.getProviderUserId())
        ).orElseGet(() -> userManager.createSocialUser(profile));

        User found = userReader.getUser(userId);

        return new AuthUser(
                found.getId(),
                found.getRole()
        );
    }
}
