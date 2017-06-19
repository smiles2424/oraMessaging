package oramessaging.security;

import oramessaging.models.User;
import oramessaging.services.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;


import java.util.Iterator;

public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepo userRepo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Iterable<User> users = userRepo.findByEmail(username);
        if (users == null) return null;
        Iterator<User> i = users.iterator();
        if (!i.hasNext()) return null;
        User user = userRepo.findByEmail(username).get(0);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), null);
    }
}