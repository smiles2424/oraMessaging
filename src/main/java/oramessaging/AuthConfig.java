package oramessaging;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import oramessaging.services.UserRepo;
import oramessaging.models.User;

@Configuration
@EnableAutoConfiguration
public class AuthConfig extends GlobalAuthenticationConfigurerAdapter {

  @Autowired
  UserRepo userRepo;

  @Override
  public void init(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService());
  }

  @Bean
  UserDetailsService userDetailsService() {
    return new UserDetailsService() {

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = userRepo.findByEmail(username);
        if (users == null || users.isEmpty()) 
          throw new UsernameNotFoundException("Not found");
        User u = users.get(0);
        
        return new org.springframework.security.core.userdetails.User(
          u.getEmail(),
          u.getPassword(),
          true,
          true,
          true,
          true,
          AuthorityUtils.createAuthorityList("USER")
          );
      }
    };
  }
}