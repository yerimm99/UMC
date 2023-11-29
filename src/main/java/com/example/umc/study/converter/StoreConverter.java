package com.example.umc.study.converter;

import com.example.umc.study.domain.Mission;
import com.example.umc.study.domain.Review;
import com.example.umc.study.web.dto.StoreRequestDTO;
import com.example.umc.study.web.dto.StoreResponseDTO;
import java.time.LocalDateTime;

public class StoreConverter {

    public static Review toReview(StoreRequestDTO.ReveiwDTO request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }

    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(StoreRequestDTO.MissionDTO request){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }

    public static StoreResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission){
        return StoreResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static StoreResponseDTO.ChallengeMissionResultDTO toChallengeMissionResultDTO(Mission mission){
        return StoreResponseDTO.ChallengeMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}