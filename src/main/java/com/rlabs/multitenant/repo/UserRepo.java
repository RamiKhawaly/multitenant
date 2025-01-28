package com.rlabs.multitenant.repo;

import com.rlabs.multitenant.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, Long> {
}
