package com.example.umc.study.service.StoreService;

import com.example.umc.study.converter.StoreConverter;
import com.example.umc.study.domain.Review;
import com.example.umc.study.repository.MemberRepository;
import com.example.umc.study.repository.ReviewRepository;
import com.example.umc.study.repository.StoreRepository;
import com.example.umc.study.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    private final StoreRepository storeRepository;

    @Override
    public Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReveiwDTO request) {

        Review review = StoreConverter.toReview(request);

        review.setMember(memberRepository.findById(memberId).get());
        review.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }
}