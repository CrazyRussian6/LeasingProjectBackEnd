package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.validators;

import lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.constraints.PaymentDateValueConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas
 */
public class PaymentDateValueValidator implements ConstraintValidator<PaymentDateValueConstraint, Integer> {

    private List<Integer> dateValues = new ArrayList<>();

    @Override
    public void initialize(PaymentDateValueConstraint constraintAnnotation) {
        for(Integer value : constraintAnnotation.value()){
            dateValues.add(value);
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return dateValues.contains(value);
    }
}
