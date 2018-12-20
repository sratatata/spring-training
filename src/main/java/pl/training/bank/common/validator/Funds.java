package pl.training.bank.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FundsValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Funds {

    long maxValue() default 10_000;

    String message() default "Invalid funds";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
