package com.example.umc.study.service.MemberService;

import com.example.umc.study.domain.Member;
import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

}