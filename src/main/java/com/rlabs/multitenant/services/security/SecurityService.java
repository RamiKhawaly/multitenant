package com.rlabs.multitenant.services.security;

import com.rlabs.multitenant.beans.User;
import com.rlabs.multitenant.beans.security.components.LoginData;
import com.rlabs.multitenant.security.jwt.JWTUtils;
import com.rlabs.multitenant.security.tenant.TenantContext;
import com.rlabs.multitenant.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    private UsersService usersBL;

    @Autowired
    private JWTUtils jwtUtils;

    public LoginData login(String username, String password)
    {
        //TenantContext.setTenantId(tenantId);
        User existingUser = this.usersBL.getUser(username);
        if(existingUser!=null)
        {
            if(existingUser.getPassword().equals(password))
            {
                String token = jwtUtils.generateJWTKey(existingUser);
                return LoginData.builder().token(token).build();
            }
        }
        return null;
    }
}
