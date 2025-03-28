package com.sezeme.mapping.section01.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "entityMember")
@Table(name = "tbl_member")
@TableGenerator(
        name = "member_seq_tbl_generator",
        table = "tbl_my_sequences",
        pkColumnValue = "my_seq_member_no"
)
@Access(AccessType.FIELD) // 클래스 레벨에 작성 시 모든 필드에 대한 접근 방식 설정 (default:FIELD)
public class Member {

    @Id
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "member_seq_tbl_generator")
    private int memberNo;

    @Access(AccessType.FIELD) // 필드  레벨에 작성 시 해당 필드에 대한 접근 방식 설정
    @Column(
            name = "member_id", unique = true,
            nullable = false, columnDefinition = "varchar(10)"
    )
    private String memberId;

    @Column(name = "member_pwd", nullable = false)
    private String memberPwd;

    @Column(name = "member_name")
    private String memberName;

//    @Transient
    @Column(name = "phone")
    private String phone;

    @Column(name = "address", length = 900)
    private String address;

    @Column(name = "enroll_date")
    private LocalDateTime enrollDate;

    @Column(name = "member_role")
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    @Column(name = "status", columnDefinition = "char(1) default 'Y'")
    private String status;

    protected Member() {}

    public Member(
            String memberId, String memberPwd, String memberName,
            String phone, String address, LocalDateTime enrollDate,
            MemberRole memberRole, String status
    ) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.phone = phone;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }

    @Access(AccessType.PROPERTY) // 해당 값의 접근 방식을 getter 메소드로 변경
    // 엔티티 값에 대한 가공 & 검증이 필요할 시 프로퍼티 접근 방식 사용
    public String getMemberName() {
        System.out.println("프로퍼티 접근 방식 사용 됨");
        // 프로퍼티 접근 방식으로 변경한다는 것은 필드 값을 가공하는 로직이 필요하다는 의미
        return memberName +"님";
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}