package UMC.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

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
    public static class StoreDTO{
        @NotBlank
        String name;
        @NotBlank
        String address;
    }

    @Getter
    public class MissionDTO {
        @NotBlank
        Integer reward;
        @NotBlank
        LocalDate deadline;
        @NotBlank
        String missionSpec;
    }
}
