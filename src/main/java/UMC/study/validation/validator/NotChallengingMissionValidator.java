package UMC.study.validation.validator;

import UMC.study.apiPayload.code.status.ErrorStatus;
import UMC.study.domain.Mission;
import UMC.study.service.missionService.MissionQueryService;
import UMC.study.validation.annotation.NotChallengingMission;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NotChallengingMissionValidator implements ConstraintValidator<NotChallengingMission, Long> {

    private final MissionQueryService missionQueryService;

    @Override
    public void initialize(NotChallengingMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<Mission> target = missionQueryService.findMission(value);

        if (!target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_CONFLICT.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
