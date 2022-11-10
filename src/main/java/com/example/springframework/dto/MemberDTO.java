package com.example.springframework.dto;

import com.example.springframework.entity.Member;
import lombok.Builder;
import lombok.Data;

public class MemberDTO {
    @Data
    public static class memberRequest {
        private Long id;
        private String name;
    }

    @Data
    public static class memberResponse {
        private Long id;
        private String name;

        public static memberResponse from(Member member) {
            memberResponse rtn = new memberResponse();
            rtn.setId(member.getId());
            rtn.setName(member.getName());
            return rtn;
        }
    }
}
