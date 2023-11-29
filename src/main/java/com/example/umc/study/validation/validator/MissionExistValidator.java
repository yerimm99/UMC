package com.example.umc.study.validation.validator;

import com.example.umc.study.domain.Mission;
import com.example.umc.study.service.StoreService.StoreQueryService;
import com.example.umc.study.validation.annotation.ExistMission;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.umc.study.apiPayload.code.status.ErrorStatus;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, Long> {

    private final StoreQueryService storeQueryService;

    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<Mission> target = storeQueryService.findMission(value);

        if (target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_CHALLENGING.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}