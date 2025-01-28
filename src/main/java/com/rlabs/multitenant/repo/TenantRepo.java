package com.rlabs.multitenant.repo;

import com.rlabs.multitenant.beans.Tenant;
import com.rlabs.multitenant.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TenantRepo extends JpaRepository<Tenant, Long> {
}
