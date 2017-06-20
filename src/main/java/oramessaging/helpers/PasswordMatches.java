package oramessaging.helpers;

import javax.validation.*;
import java.lang.annotation.*;
import oramessaging.helpers.PasswordMatchesValidator;

/**
 * Custom attribute to validate matching passwords
 */

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
  String message() default "Passwords don't match";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}

