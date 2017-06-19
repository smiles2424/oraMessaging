package oramessaging.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import oramessaging.models.User;

public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findByEmail(String email);
    
}
