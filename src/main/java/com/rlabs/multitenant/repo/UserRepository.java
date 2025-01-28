package com.rlabs.multitenant.repo;


import com.rlabs.multitenant.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
