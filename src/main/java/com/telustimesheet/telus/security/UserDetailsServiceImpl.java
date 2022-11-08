package com.telustimesheet.telus.security;

import com.telustimesheet.telus.entities.UserEntity;
import com.telustimesheet.telus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(username);
        UserBuilder builder = null;

        if (userEntity != null) {
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(userEntity.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));

        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return builder.build();
    }

}
