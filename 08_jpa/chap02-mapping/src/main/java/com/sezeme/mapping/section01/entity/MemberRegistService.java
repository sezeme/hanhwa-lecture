package com.sezeme.mapping.section01.entity;

import org.hibernate.metamodel.internal.MemberResolver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberRegistService {

    private MemberRepository memberRepository;

    public MemberRegistService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void registMember(MemberRegistDTO newMember) {
        // dto -> entity
        Member member = new Member(
                newMember.getMemberId(),
                newMember.getMemberPwd(),
                newMember.getMemberName(),
                newMember.getPhone(),
                newMember.getAddress(),
                newMember.getEnrollDate(),
                newMember.getMemberRole(),
                newMember.getStatus()
        );

        memberRepository.save(member);
    }

    /* Spring 의 트랜잭션 전파 방식 : default 는 PROPAGATION_REQUIRED
    * @Transactional 이 붙은 메소드 내부에서 다시 @Transactional 이 붙은 메소드를 호출하면
    * 호출 된 메소드는 호출 한 메소드와 동일한 트랜잭션 컨텍스트를 사용하게 된다.
    * 없으면 새로 만들고, 있으면 있던 거 쓴다. 하나의 트랜잭션 안에서 동작이 일어난다. */
    @Transactional
    public String registMemberAndFindName(MemberRegistDTO newMember) {
        registMember(newMember);
        return memberRepository.findNameById(newMember.getMemberId());
    }
}
