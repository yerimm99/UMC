package com.example.umc.study.web.controller;

import com.example.umc.study.apiPayload.ApiResponse;
import com.example.umc.study.converter.StoreConverter;
import com.example.umc.study.domain.Mission;
import com.example.umc.study.domain.Review;
import com.example.umc.study.service.StoreService.StoreCommandService;
import com.example.umc.study.service.StoreService.StoreQueryService;
import com.example.umc.study.validation.annotation.ExistMember;
import com.example.umc.study.validation.annotation.ExistMission;
import com.example.umc.study.validation.annotation.ExistStore;
import com.example.umc.study.web.dto.StoreRequestDTO;
import com.example.umc.study.web.dto.StoreResponseDTO.ChallengeMissionResultDTO;
import com.example.umc.study.web.dto.StoreResponseDTO.CreateMissionResultDTO;
import com.example.umc.study.web.dto.StoreResponseDTO.CreateReviewResultDTO;
import jakarta.validation.Valid;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    private final StoreQueryService storeQueryService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReveiwDTO request,
                                                           @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                           @ExistMember @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<CreateMissionResultDTO> createMission(@RequestBody @Valid StoreRequestDTO.MissionDTO request,
                                                             @ExistStore @PathVariable(name = "storeId") Long storeId){
        Mission mission = storeCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateMissionResultDTO(mission));
    }

    @PostMapping("/missions/challenge/{missionId}")
    public ApiResponse<ChallengeMissionResultDTO> challengeMission(@RequestBody @Valid StoreRequestDTO.ChallengeMissionDTO request,
                                                                @ExistMission @PathVariable(name = "missionId") Long missionId){
        Mission mission = storeCommandService.findMission(missionId);
        return ApiResponse.onSuccess(StoreConverter.toChallengeMissionResultDTO(mission));
    }
}