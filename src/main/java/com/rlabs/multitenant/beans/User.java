package com.rlabs.multitenant.beans;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

// User Entity
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    private String name;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;


}

