package com.example.springframework.service;

import com.example.springframework.dto.MemberDTO;
import com.example.springframework.entity.Member;
import com.example.springframework.entity.Team;
import com.example.springframework.exception.CustomException;
import com.example.springframework.exception.Errors;
import com.example.springframework.repository.MemberRepository;
import com.example.springframework.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    public List<MemberDTO.memberResponse> getMembers() {
        return this.memberRepository.findAll().stream().map(MemberDTO.memberResponse::from).collect(Collectors.toList());
    }

    public List<MemberDTO.teamResponse> getTeams() {
        return this.teamRepository.findAll().stream().map(MemberDTO.teamResponse::from).collect(Collectors.toList());
    }


    public MemberDTO.memberResponse getMember(Long id) {
        return this.memberRepository.findById(id).map(MemberDTO.memberResponse::from).orElseThrow(() -> new CustomException(Errors.INTERNAL_SERVER_ERROR));
    }

    public MemberDTO.memberResponse postMember(MemberDTO.memberRequest param) {
        Member member = new Member();
        member.setName(param.getName());
        this.memberRepository.save(member);

        MemberDTO.memberResponse response = new MemberDTO.memberResponse();
        response.setId(member.getId());
        response.setName(member.getName());
        return response;
    }

    public MemberDTO.memberResponse patchMember(MemberDTO.memberRequest param) {
        Member member = this.memberRepository.findById(param.getId()).orElseThrow(()-> new CustomException(Errors.INTERNAL_SERVER_ERROR));
        member.setName(param.getName());
        this.memberRepository.save(member);

        MemberDTO.memberResponse response = new MemberDTO.memberResponse();
        response.setId(member.getId());
        response.setName(member.getName());
        return response;
    }

    public void deleteMember(MemberDTO.memberRequest param) {
        Member member = this.memberRepository.findById(param.getId()).orElseThrow(()-> new CustomException(Errors.INTERNAL_SERVER_ERROR));
        this.memberRepository.delete(member);
    }


}
