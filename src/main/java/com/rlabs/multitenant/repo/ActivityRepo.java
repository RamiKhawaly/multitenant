package com.rlabs.multitenant.repo;

import com.rlabs.multitenant.beans.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<Activity, Long> {
}
