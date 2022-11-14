package com.example.springframework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "team")
@NoArgsConstructor
public class Team {
    @Id  // Primary Key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // AUTO_INCREMENT 설정 (id값이 null일 경우 자동 생성)
    @Column(name = "id")  // 컬럼 지정
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="teamId")
    @OrderBy("id DESC")
    @Where(clause="deleteAt=0")
    private List<Member> membersnotdel = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="teamId")
    @OrderBy("id DESC")
    @Where(clause="deleteAt=1")
    private List<Member> membersdel = new ArrayList<>();






}
