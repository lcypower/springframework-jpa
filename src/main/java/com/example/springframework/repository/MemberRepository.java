package com.example.springframework.repository;

import com.example.springframework.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository  extends JpaRepository<Member, Long> {
}
