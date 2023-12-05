package com.example.umc.study.service.StoreService;

import com.example.umc.study.domain.Mission;
import com.example.umc.study.domain.Review;
import com.example.umc.study.domain.Store;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    Page<Review> getReviewList(Long StoreId, Integer page);
    Page<Mission> getMissionList(Long StoreId, Integer page);
    Page<Mission> getMemberMissionList(Long MemberId, Integer page);
    Optional<Mission> findMission(Long id);
}