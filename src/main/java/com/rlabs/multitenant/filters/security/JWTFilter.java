package com.rlabs.multitenant.filters.security;

import com.rlabs.multitenant.security.jwt.JWTUtils;
import com.rlabs.multitenant.security.tenant.TenantContext;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtils jwtUtils;

    @Value("${application.security.openURLS}")
    private List<String> openUrls;

    @Value("${application.security.multi-tenant-header-key}")
    private String multiTenantKey;

    private final AntPathMatcher matcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("Request received: " + path);

        // Check if the URL is in the list of open (unprotected) URLs
        boolean isOpenUrl = openUrls.stream().anyMatch(pattern -> matcher.match(pattern, path));

        if (!isOpenUrl) {
            // Validate JWT
            if (!isValidRequest(request)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Unauthorized or invalid token");
                response.getWriter().flush();
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean isValidRequest(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        String path = request.getServletPath();

        if (token == null) {
            System.out.println("Request " + path + " didn't include a token");
            return false;
        }

        // Strip out 'Bearer' prefix
        token = token.replace("Bearer", "").trim();

        try {
            Claims claims = this.jwtUtils.verifyToken(token);
            if (claims != null) {
                System.out.println("Welcome " + claims.getSubject());
                String tenantId = claims.get(multiTenantKey).toString();
                TenantContext.setTenantId(tenantId);
                return true;
            }

        } catch (Exception e) {
            System.out.println("Token verification failed: " + e.getMessage());
        }

        System.out.println("Request " + path + " with invalid token " + token);
        return false;
    }
}
