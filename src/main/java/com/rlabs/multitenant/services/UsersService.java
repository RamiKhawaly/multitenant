package com.rlabs.multitenant.services;

import com.rlabs.multitenant.beans.User;
import com.rlabs.multitenant.repo.UserRepository;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String username)
    {
        User existingUser = this.userRepository.findByUsername(username);
        if(existingUser !=null)
        {
            return existingUser;
        }
        return null;
    }
}
