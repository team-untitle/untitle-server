package com.team.moodit.clients.kakao.model;

import com.team.moodit.clients.kakao.KakaoTokenResponse;

public record KakaoClientTokenResult(
        String accessToken,
        String refreshToken
) {
    public static KakaoClientTokenResult of(KakaoTokenResponse response) {
        return new KakaoClientTokenResult(
                response.accessToken(),
                response.refreshToken()
        );
    }
}
