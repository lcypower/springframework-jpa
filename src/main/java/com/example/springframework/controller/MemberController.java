package com.example.springframework.controller;

import com.example.springframework.dto.MemberDTO;
import com.example.springframework.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@Slf4j
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/v1/teams")
    public ResponseEntity<Object> getTeams(){
        return ResponseEntity.ok(this.memberService.getTeams());
    }

    @GetMapping("/v1/members")
    public ResponseEntity<Object> getMembers(){
        return ResponseEntity.ok(this.memberService.getMembers());
    }

    @GetMapping("/v1/member/{id}")
    public ResponseEntity<Object> getMember(@PathVariable("id") Long id){
        return new ResponseEntity(this.memberService.getMember(id), HttpStatus.OK);
    }

    @PostMapping("/v1/member")
    public ResponseEntity<Object> postMain(@RequestBody MemberDTO.memberRequest param){
        MemberDTO.memberResponse response = this.memberService.postMember(param);
        return ResponseEntity.created(URI.create("/v1/member/" + response.getId())).build();
    }

    @PatchMapping("/v1/member")
    public ResponseEntity<Object> patchMain(@RequestBody MemberDTO.memberRequest param) {
        return new ResponseEntity(this.memberService.patchMember(param), HttpStatus.OK);
    }

    @DeleteMapping("/v1/member")
    public ResponseEntity<Object> deleteMain(@ModelAttribute MemberDTO.memberRequest param){
        this.memberService.deleteMember(param);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
