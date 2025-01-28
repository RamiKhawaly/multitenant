package com.rlabs.multitenant.repo;

import com.rlabs.multitenant.beans.Activity;
import com.rlabs.multitenant.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivityRepo extends JpaRepository<Activity, Long> {
}
