package com.example.umc.study.service.MemberService;

import com.example.umc.study.domain.Member;
import com.example.umc.study.web.dto.MemberRequest;

public interface MemberCommandService {

    Member joinMember(MemberRequest.JoinDto request);
}