package com.example.assignment1_28_02_26.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment1_28_02_26.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
