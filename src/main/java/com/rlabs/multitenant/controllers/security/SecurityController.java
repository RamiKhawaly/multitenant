package com.rlabs.multitenant.controllers.security;

import com.rlabs.multitenant.beans.security.components.LoginData;
import com.rlabs.multitenant.services.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication")
@CrossOrigin
public class SecurityController {

    @Autowired
    private SecurityService securityBL;

    @GetMapping("login")
    public ResponseEntity<LoginData> login(String username, String password)
    {
        LoginData loginData = securityBL.login(username,password);
        if(loginData!=null)
        {
            return ResponseEntity.ok(loginData);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }


}
