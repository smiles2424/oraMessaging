package oramessaging.helpers;

import oramessaging.helpers.PasswordMatches;
import oramessaging.models.User;

import javax.validation.*;

/**
 * Implementation of custom validation annotation for passwords
 */
public class PasswordMatchesValidator 
  implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches p) {}
    
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
      User user = (User) obj;
      if (user.getPassword() == null || user.getConfirmedPassword() == null) 
        return false;
      return user.getPassword().equals(user.getConfirmedPassword());
    }

  }
  