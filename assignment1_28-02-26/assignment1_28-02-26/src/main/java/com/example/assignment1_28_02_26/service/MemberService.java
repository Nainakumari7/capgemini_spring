package com.example.assignment1_28_02_26.service;

import java.util.List;
import com.example.assignment1_28_02_26.Member;

public interface MemberService {

    void addMember(Member member);

    Member getMemberById(Long memberId);

    List<Member> getAllMembers();

    void updateMember(Long memberId, Member updatedMember);

    void deleteOrDisableMember(Long memberId);
}