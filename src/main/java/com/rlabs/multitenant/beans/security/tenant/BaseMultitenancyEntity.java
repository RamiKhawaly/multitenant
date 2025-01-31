package com.rlabs.multitenant.beans.security.tenant;

/**
 * Data Entities for Nexus System in Spring Boot with Multi-Tenancy Support using Spring Boot's Built-In Tenant Context.
 * Updated with Lombok annotations for boilerplate code reduction.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.TenantId;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public abstract class BaseMultitenancyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @TenantId // Hibernate annotation for tenant identification
    @JsonIgnore
    private String tenantId; // Identifier for the tenant
}