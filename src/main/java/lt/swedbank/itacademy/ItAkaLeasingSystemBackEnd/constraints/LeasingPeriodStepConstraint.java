package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.constraints;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.validators.LeasingPeriodStepValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LeasingPeriodStepValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LeasingPeriodStepConstraint{
    String message() default "Invalid leasing period";
    Class<?>[] groups() default {};
    Class <? extends Payload>[] payload() default {};
}
