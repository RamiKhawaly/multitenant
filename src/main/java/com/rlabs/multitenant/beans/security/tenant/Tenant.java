package com.rlabs.multitenant.beans.security.tenant;
import com.rlabs.multitenant.beans.BaseEntity;
import com.rlabs.multitenant.beans.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// Tenant Entity for Managing Multi-Tenancy
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant extends BaseEntity {

    private String name;
    private String domain;

    @OneToMany(mappedBy = "tenant")
    private List<User> user;

}

