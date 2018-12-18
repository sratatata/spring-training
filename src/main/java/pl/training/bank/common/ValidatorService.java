package pl.training.bank.common;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ValidatorService {

    @NonNull
    private Validator validator;

    public <O, E extends RuntimeException> void validate(O object, Class<E> exceptionType) throws E {
        Set<ConstraintViolation<O>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            try {
                Constructor<E> exception = exceptionType.getDeclaredConstructor();
                throw exception.newInstance();
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                throw new IllegalArgumentException();
            }
        }
    }

}
