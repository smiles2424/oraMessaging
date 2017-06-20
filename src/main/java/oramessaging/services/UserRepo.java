package oramessaging.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import oramessaging.models.User;

/**
 * This class uses the Spring framework default implementation to pull Users
 * from the in-memory database.
 * 
 * It includes another findBy* to pull by email for Authentication purposes
 * 
 */

public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findByEmail(String email);
    
}
