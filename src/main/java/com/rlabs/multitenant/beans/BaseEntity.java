package com.rlabs.multitenant.beans;

/**
 * Data Entities for Nexus System in Spring Boot with Multi-Tenancy Support using Spring Boot's Built-In Tenant Context.
 * Updated with Lombok annotations for boilerplate code reduction.
 */

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.TenantId;

import java.util.*;
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PreUpdate
    public void setLastUpdate() {
        this.updatedAt = new Date();
    }

    @TenantId // Hibernate annotation for tenant identification
    private String tenantId; // Identifier for the tenant
}