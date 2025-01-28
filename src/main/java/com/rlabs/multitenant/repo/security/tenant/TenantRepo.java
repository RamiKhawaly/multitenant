package com.rlabs.multitenant.repo.security.tenant;

import com.rlabs.multitenant.beans.security.tenant.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepo extends JpaRepository<Tenant, Long> {
}
