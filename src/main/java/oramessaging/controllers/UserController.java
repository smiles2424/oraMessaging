package oramessaging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import oramessaging.models.User;
import oramessaging.services.UserRepo;

@RestController
public class UserController {
  @Autowired
  private UserRepo userRepo;

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User user(@PathVariable("id") long id) {
        return userRepo.findOne(id);
    }

    @RequestMapping(path="/users", method=RequestMethod.GET)
    public Iterable<User> getUsers(){
      return userRepo.findAll();
    }

    @RequestMapping(path="/user", method=RequestMethod.POST)
    public User saveuser(@RequestBody User user){
      System.out.println("User was saved!");
      return userRepo.save(user);
    }
}
