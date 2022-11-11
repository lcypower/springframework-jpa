package com.example.springframework.dto;

import com.example.springframework.entity.Member;
import com.example.springframework.entity.Team;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public class MemberDTO {
    @Data
    public static class memberRequest {
        private Long id;
        private String name;
        private int level;
    }

    @Data
    public static class memberResponse {
        private Long id;
        private String name;
        private int level;
        private String teamName;

        public static memberResponse from(Member member) {
            memberResponse rtn = new memberResponse();
            rtn.setId(member.getId());
            rtn.setName(member.getName());
            rtn.setLevel(member.getLevel());
            rtn.setTeamName(member.getTeam().getName());
            return rtn;
        }
    }

    @Data
    public static class teamResponse {
        private Long id;
        private String name;
        private List<Member> members;

        public static teamResponse from(Team team) {
            teamResponse rtn = new teamResponse();
            rtn.setId(team.getId());
            rtn.setName(team.getName());
            rtn.setMembers(team.getMembers());
            return rtn;
        }
    }


}
