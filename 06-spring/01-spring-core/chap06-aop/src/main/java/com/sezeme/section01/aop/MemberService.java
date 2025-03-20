package com.sezeme.section01.aop;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {
    private final MemberDAO memberDAO;
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }
    public Map<Long, MemberDTO> selectMembers(){
        System.out.println("selectMembers 메소드 실행");
        return memberDAO.selectMembers();
    }
    public MemberDTO selectMember(Long id) {

        System.out.println("selectMember 메소드 실행");
        return memberDAO.selectMember(id);
    }
}
