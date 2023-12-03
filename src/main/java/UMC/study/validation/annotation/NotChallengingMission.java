package UMC.study.validation.annotation;

import UMC.study.validation.validator.NotChallengingMissionValidator;
import UMC.study.validation.validator.StoreExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotChallengingMissionValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotChallengingMission {
    String message() default "해당하는 미션은 이미 진행중 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}