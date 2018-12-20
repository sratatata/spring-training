package pl.training.bank.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FundsValidator implements ConstraintValidator<Funds, Long> {

   private long maxValue;

   public void initialize(Funds constraint) {
      maxValue = constraint.maxValue();
   }

   public boolean isValid(Long value, ConstraintValidatorContext context) {
      return value > 0 && value <= maxValue;
   }

}
