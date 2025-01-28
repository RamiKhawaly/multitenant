package com.rlabs.multitenant.beans;

import com.rlabs.multitenant.beans.security.tenant.BaseMultitenancyEntity;
import jakarta.persistence.*;
import lombok.*;


// Activity Entity
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity extends BaseMultitenancyEntity {
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private ActivityType type;

}

