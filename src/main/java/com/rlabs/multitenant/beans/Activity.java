package com.rlabs.multitenant.beans;

import jakarta.persistence.*;
import lombok.*;


// Activity Entity
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity extends BaseEntity {
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private ActivityType type;

}

