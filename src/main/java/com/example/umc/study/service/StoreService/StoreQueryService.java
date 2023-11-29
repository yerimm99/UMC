package com.example.umc.study.service.StoreService;

import com.example.umc.study.domain.Mission;
import com.example.umc.study.domain.Store;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    Optional<Mission> findMission(Long id);
}