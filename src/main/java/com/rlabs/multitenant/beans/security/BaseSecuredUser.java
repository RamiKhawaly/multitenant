package com.rlabs.multitenant.beans.security;

import com.rlabs.multitenant.beans.BaseEntity;
import com.rlabs.multitenant.beans.security.tenant.BaseMultitenancyEntity;
import com.rlabs.multitenant.beans.security.tenant.Tenant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BaseSecuredUser extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;
    
    @Column(unique = true)
    private String username;

    private String password;
}
