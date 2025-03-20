package com.sezeme.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAO {
    private final Map<Long, MemberDTO> memberMap;
    public MemberDAO(){
        memberMap = new HashMap<>();
        memberMap.put(1L, new MemberDTO(1L, "유관순"));
        memberMap.put(2L, new MemberDTO(2L, "홍길동"));
    }
    public Map<Long, MemberDTO> selectMembers(){
        return memberMap;
    };
    public MemberDTO selectMember(Long id) {
        MemberDTO returnMember = memberMap.get(id);
        if(returnMember == null) throw new RuntimeException("해당하는 id의 회원이 없습니다.");
        return returnMember;
    }
}
