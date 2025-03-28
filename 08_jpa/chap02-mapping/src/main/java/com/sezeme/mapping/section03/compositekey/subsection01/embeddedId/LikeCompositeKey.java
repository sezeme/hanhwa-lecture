package com.sezeme.mapping.section03.compositekey.subsection01.embeddedId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/* Serializable 반드시 붙여야 함. -> 왜???? */
/* JPA 명세 : 복합키 타입에서 Serializable 구현 요구
Hibernate 등의 구현체 : 실제 사용 환경(예: 분산 환경 미사용)에서는 요구사항을 엄격하게 강제하지 않도록 내부적으로 변경
명세 준수와 향후 호환성을 위해 복합키 클래스에 Serializable 을 구현하는 것이 권장
*/
@Embeddable
public class LikeCompositeKey implements Serializable {
    @Column(name = "liked_member_no")
    private int likedMemberNo;

    @Column(name = "liked_book_no")
    private int likedBookNo;

    protected LikeCompositeKey() {}

    public LikeCompositeKey(int likedMemberNo, int likedBookNo) {
        this.likedMemberNo = likedMemberNo;
        this.likedBookNo = likedBookNo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LikeCompositeKey that = (LikeCompositeKey) o;
        return likedMemberNo == that.likedMemberNo && likedBookNo == that.likedBookNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(likedMemberNo, likedBookNo);
    }

    @Override
    public String toString() {
        return "LikeCompositeKey{" +
                "likedMemberNo=" + likedMemberNo +
                ", likedBookNo=" + likedBookNo +
                '}';
    }
}