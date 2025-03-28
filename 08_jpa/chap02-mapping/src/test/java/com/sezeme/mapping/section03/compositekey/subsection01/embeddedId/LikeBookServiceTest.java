package com.sezeme.mapping.section03.compositekey.subsection01.embeddedId;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LikeBookServiceTest {

    @Autowired
    private LikeBookService likeBookService;

    private static Stream<Arguments> getLikeInfo() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(1, 2),
                Arguments.of(2, 2)
        );
    }

    @ParameterizedTest(name = "{0}번 회원이 {1}번 책을 좋아요 등록 테스트")
    @MethodSource("getLikeInfo")
    void testGenerateLike(int likedMemberNo, int likedBookNo) {
        //given
        //when
        //then
        Assertions.assertDoesNotThrow(
                () -> likeBookService.generateLikeBook(
                        new LikeDTO(likedMemberNo, likedBookNo)
                )
        );
    }
}
