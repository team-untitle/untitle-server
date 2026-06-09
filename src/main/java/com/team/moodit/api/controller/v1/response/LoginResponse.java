package com.team.moodit.api.controller.v1.response;

public record LoginResponse(
        Long userId,
        String accessToken,
        String refreshToken
) {
}
