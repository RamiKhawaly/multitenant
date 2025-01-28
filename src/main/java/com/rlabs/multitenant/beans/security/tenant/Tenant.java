package com.rlabs.multitenant.beans.security.tenant;
import com.rlabs.multitenant.beans.DatabaseType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

// Tenant Entity for Managing Multi-Tenancy
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String schemaName; // Schema name for tenant-specific database
    private String databaseUrl; // Optional: External DB connection for the tenant

    @Enumerated(EnumType.STRING)
    private DatabaseType databaseType;

   // @OneToMany(mappedBy = "tenant")
   // private List<Organization> organizations = new ArrayList<>();
}

