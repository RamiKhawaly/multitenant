package com.rlabs.multitenant.multiTenant;

import org.springframework.stereotype.Component;

@Component
public class TenantContext {
    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setTenantId(String tenantId) {
        currentTenant.set(tenantId);
    }

    public static String getTenantId() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }

    /**
     * Checks if a tenant ID is set in the current thread context.
     *
     * @return True if a tenant ID is set, false otherwise.
     */
    public static boolean hasTenantId() {
        return currentTenant.get() != null;
    }
}

