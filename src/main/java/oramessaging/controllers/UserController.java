package oramessaging.controllers;

import java.util.ArrayList;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import oramessaging.models.Error;
import oramessaging.models.Response;
import oramessaging.models.User;
import oramessaging.models.Login;
import oramessaging.services.UserRepo;

@RestController
public class UserController {
  @Autowired
  private UserRepo userRepo;

    @RequestMapping(path = "/auth/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody Login login) {
        User u = userRepo.findByEmail(login.getEmail()).get(0);
        if (login.getPassword().equals(u.getPassword())){
          //JWT it up
          ResponseEntity<User> res = new ResponseEntity<User>(u, HttpStatus.ACCEPTED);
          return res;
        } else {
          ResponseEntity<String> res = new ResponseEntity<String>(
            "Authentication Failed", 
            HttpStatus.UNAUTHORIZED);
          return res;
        }
    }

    @RequestMapping(path="/users", method=RequestMethod.GET)
    public Iterable<User> getUsers(){
      return userRepo.findAll();
    }

    @RequestMapping(path="/user", method=RequestMethod.POST)
    public Response<User> saveUser(@RequestBody User user){

      // Create error collection for validation exceptions
      // TODO custom validation, shouldn't use exceptions for expected behavior
      // TODO move to service layer
      // Check for duplicate emails

      ArrayList<Error> errors = new ArrayList<Error>();
      User u = null;
      String message = "Success";
      try {
        u = userRepo.save(user);
      } catch (ConstraintViolationException e) {
        message = "Validation failed";
        for(ConstraintViolation v : e.getConstraintViolations()){
          Error error = new Error(
              v.getPropertyPath() + " " + v.getMessage()
            );
          errors.add(error);
        }
      }
      
      Response<User> res = new Response<User>(u);
      res.setMessage(message);
      res.setErrors(errors);
      return res;
    }
}
