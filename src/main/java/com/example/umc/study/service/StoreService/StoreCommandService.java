package com.example.umc.study.service.StoreService;

import com.example.umc.study.domain.Mission;
import com.example.umc.study.domain.Review;
import com.example.umc.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReveiwDTO request);

    Mission createMission(Long storeId, StoreRequestDTO.MissionDTO request);

    Mission findMission(Long missionId);
}