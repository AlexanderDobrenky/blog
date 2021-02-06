package ru.dobrenky.blog.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface PasswordMatches {
    String message() default "Password not matches";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
