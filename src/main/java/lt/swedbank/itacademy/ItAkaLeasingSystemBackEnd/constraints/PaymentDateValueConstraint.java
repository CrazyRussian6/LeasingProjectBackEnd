package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.constraints;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.validators.PaymentDateValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = PaymentDateValueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PaymentDateValueConstraint{
    String message() default "Invalid payment date value";
    Class<?>[] groups() default {};
    Class <? extends Payload>[] payload() default {};
    int[] value();
}