package com.example.umc.study.web.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class ReveiwDTO{
        @NotBlank
        String title;
        @NotNull
        Float score;
        @NotBlank
        String body;
    }

    @Getter
    public static class MissionDTO{
        @NotBlank
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotBlank
        String missionSpec;
    }

    @Getter
    public static class ChallengeMissionDTO{
        @NotBlank
        Long id;
    }
}