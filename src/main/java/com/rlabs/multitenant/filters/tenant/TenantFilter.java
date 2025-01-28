package com.rlabs.multitenant.filters.tenant;

import com.rlabs.multitenant.security.tenant.TenantContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TenantFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String tenantId = request.getHeader("X-Tenant-ID");
        if(tenantId!=null && !"".equals(tenantId)) {
            TenantContext.setTenantId(tenantId);
        }
        filterChain.doFilter(request,response);
    }
}
