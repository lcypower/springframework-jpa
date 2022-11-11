package com.example.springframework.repository;

import com.example.springframework.entity.Member;
import com.example.springframework.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
