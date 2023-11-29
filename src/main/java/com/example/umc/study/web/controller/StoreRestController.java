package com.example.umc.study.web.controller;

import com.example.umc.study.apiPayload.ApiResponse;
import com.example.umc.study.converter.StoreConverter;
import com.example.umc.study.domain.Review;
import com.example.umc.study.service.StoreService.StoreCommandService;
import com.example.umc.study.validation.annotation.ExistMember;
import com.example.umc.study.validation.annotation.ExistStore;
import com.example.umc.study.web.dto.StoreRequestDTO;
import com.example.umc.study.web.dto.StoreResponseDTO.CreateReviewResultDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReveiwDTO request,
                                                           @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                           @ExistMember @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }
}