package com.example.umc.study.converter;

import com.example.umc.study.domain.Member;
import com.example.umc.study.domain.enums.Gender;
import com.example.umc.study.web.dto.MemberRequest;
import com.example.umc.study.web.dto.MemberResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponse.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponse.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequest.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}