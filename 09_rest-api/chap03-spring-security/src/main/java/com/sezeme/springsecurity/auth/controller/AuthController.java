package com.sezeme.springsecurity.auth.controller;
import com.sezeme.springsecurity.auth.dto.LoginRequest;
import com.sezeme.springsecurity.auth.dto.TokenResponse;
import com.sezeme.springsecurity.auth.service.AuthService;
import com.sezeme.springsecurity.common.ApiResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

/* HttpOnly 쿠키
 * - HttpOnly 속성이 설정된 쿠키는 클라이언트 측 JavaScript 에서 접근할 수 없다.
 * - XSS(Cross-Site Scripting) 공격으로부터 refreshToken 탈취를 방지하기 위해 사용한다.
 * - SameSite=Strict 옵션을 통해 CSRF(Cross-Site Request Forgery) 공격도 완화할 수 있다.
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponse>> login(@RequestBody LoginRequest request) {
        TokenResponse tokenResponse = authService.login(request);
        return buildTokenResponse(tokenResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<TokenResponse>> refreshToken(
            @CookieValue(name = "refreshToken", required = false) String refreshToken // HttpOnly 쿠키에서 읽어옴
    ) {
        if (refreshToken == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // refreshToken이 없으면 401 반환
        }
        TokenResponse tokenResponse = authService.refreshToken(refreshToken);
        return buildTokenResponse(tokenResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(
            @CookieValue(name = "refreshToken", required = false) String refreshToken // HttpOnly 쿠키에서 읽어옴
    ) {
        if (refreshToken != null) {
            authService.logout(refreshToken);
        }
        ResponseCookie deleteCookie = createDeleteRefreshTokenCookie(); // 만료용 쿠키 생성
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, deleteCookie.toString())
                .body(ApiResponse.success(null));
    }

    /* accessToken 과 refreshToken을 body와 쿠키에 담아 반환 */
    private ResponseEntity<ApiResponse<TokenResponse>> buildTokenResponse(TokenResponse tokenResponse) {
        ResponseCookie cookie = createRefreshTokenCookie(tokenResponse.getRefreshToken());  // refreshToken 쿠키 생성
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(ApiResponse.success(tokenResponse));
    }

    /* refreshToken 쿠키 생성 */
    private ResponseCookie createRefreshTokenCookie(String refreshToken) {
        return ResponseCookie.from("refreshToken", refreshToken)
                .httpOnly(true)                     // HttpOnly 속성 설정 (JavaScript 에서 접근 불가)
                // .secure(true)                    // HTTPS 환경일 때만 전송 (운영 환경에서 활성화 권장)
                .path("/")                          // 쿠키 범위 : 전체 경로
                .maxAge(Duration.ofDays(7))         // 쿠키 만료 기간 : 7일
                .sameSite("Strict")                 // CSRF 공격 방어를 위한 SameSite 설정
                .build();
    }

    /* 쿠키 삭제용 설정
     * 빈 값 + maxAge=0 으로 즉시 만료시켜 브라우저에서 삭제
     */
    private ResponseCookie createDeleteRefreshTokenCookie() {
        return ResponseCookie.from("refreshToken", "")
                .httpOnly(true)     // HttpOnly 유지
                // .secure(true)    // HTTPS 환경에서만 사용 시 주석 해제
                .path("/")          // 동일 path 범위
                .maxAge(0)          // 즉시 만료
                .sameSite("Strict") // SameSite 유지
                .build();
    }
}
