package com.teachmeskills.springbooteshop.services;

import com.teachmeskills.springbooteshop.entities.User;
import com.teachmeskills.springbooteshop.repositories.UserRepository;
import com.teachmeskills.springbooteshop.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // User user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found "));
        // return new CustomUserDetails(user);
        CustomUserDetails userDetails;
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isPresent()) {
            userDetails = new CustomUserDetails(user.get());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
        return userDetails;


    }
}
