package pl.training.bank.common;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;

@Aspect
@RequiredArgsConstructor
public class ModelValidator {

    @NonNull
    private ValidatorService validatorService;

    @Before("execution(* *(@Validate (*)))")
    public void validate(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Annotation[][] annotations = methodSignature.getMethod().getParameterAnnotations();
        Object[] args = joinPoint.getArgs();
        for (int index = 0; index < args.length; index++) {
           for (int annotationIndex = 0; annotationIndex < annotations[index].length; annotationIndex++) {
               if (annotations[index][annotationIndex] instanceof Validate) {
                   validatorService.validate(args[index], ((Validate) annotations[index][annotationIndex]).exception());
               }
           }
        }
    }

}
