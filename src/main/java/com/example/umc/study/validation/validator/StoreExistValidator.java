package com.example.umc.study.validation.validator;

import com.example.umc.study.domain.Store;
import com.example.umc.study.service.StoreService.StoreQueryService;
import com.example.umc.study.validation.annotation.ExistStore;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.umc.study.apiPayload.code.status.ErrorStatus;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreQueryService storeQueryService;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<Store> target = storeQueryService.findStore(value);

        if (target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}