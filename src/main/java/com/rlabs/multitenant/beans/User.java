package com.rlabs.multitenant.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlabs.multitenant.beans.security.BaseSecuredUser;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users"/*, uniqueConstraints = {
        @UniqueConstraint(columnNames = {"tenant_id", "username"}),
        @UniqueConstraint(columnNames = {"tenant_id", "email"})
}*/)
public class User extends BaseSecuredUser {

    @Column(unique = true)
    private String email;

    private boolean isEnabled;
}
