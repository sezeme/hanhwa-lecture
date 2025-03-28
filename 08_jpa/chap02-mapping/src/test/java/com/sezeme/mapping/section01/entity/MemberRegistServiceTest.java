package com.sezeme.mapping.section01.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRegistServiceTest {
    @Autowired
    private MemberRegistService memberRegistService;

    private static Stream<Arguments> getMember() {
        return Stream.of(
                Arguments.of(
                        "user01",
                        "pass01",
                        "홍길동",
                        "010-1234-5678",
                        "서울 동작구",
                        LocalDateTime.now(),
                        "ROLE_ADMIN",
                        "Y"
                ),
                Arguments.of(
                        "user02",
                        "pass02",
                        "유관순",
                        "010-1234-4444",
                        "서울시 동작구",
                        LocalDateTime.now(),
                        "ROLE_USER",
                        "N"
                )
        );
    }

    @DisplayName("테이블 생성 테스트")
    @ParameterizedTest
    @MethodSource("getMember")
    void testCreateTable(
            String memberId, String memberPwd, String memberName,
            String phone, String address, LocalDateTime enrollDate,
            MemberRole memberRole, String status
    ) {
        MemberRegistDTO newMember = new MemberRegistDTO(
                memberId,
                memberPwd,
                memberName,
                phone,
                address,
                enrollDate,
                memberRole,
                status
        );

        assertDoesNotThrow(
                () -> memberRegistService.registMember(newMember)
        );
    }

    @DisplayName("프로퍼티 접근 테스트")
    @ParameterizedTest
    @MethodSource("getMember")
    void testAccessProperty(
            String memberId, String memberPwd, String memberName,
            String phone, String address, LocalDateTime enrollDate,
            MemberRole memberRole, String status
    ) {
        MemberRegistDTO newMember = new MemberRegistDTO(
                memberId,
                memberPwd,
                memberName,
                phone,
                address,
                enrollDate,
                memberRole,
                status
        );

        String registedName = memberRegistService.registMemberAndFindName(newMember);

        assertEquals(memberName + "님", registedName);
    }
}