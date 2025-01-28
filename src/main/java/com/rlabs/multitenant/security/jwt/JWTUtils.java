package com.rlabs.multitenant.security.jwt;

import com.rlabs.multitenant.beans.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;

@Service
public class JWTUtils {

    @Value("${application.security.jwt.secret-key}")
    private String jwtSecret;

    @Value("${application.security.jwt.expiration}")
    private int expirationMinutes;

    @Value("${application.security.multi-tenant-header-key}")
    private String multiTenantKey;

    private Key secretKey;

    @PostConstruct
    public void init()
    {
        this.secretKey = new SecretKeySpec(jwtSecret.getBytes(), SignatureAlgorithm.HS512.getJcaName());
    }

    public String generateJWTKey(User user)
    {
        Date expirationTime = new Date(Calendar.getInstance().getTimeInMillis()+expirationMinutes*1000*60);

        return Jwts.builder()
                .setIssuer(user.getTenant().getName())
                .setExpiration(expirationTime)
                .setIssuedAt(new Date(Calendar.getInstance().getTimeInMillis()))
                .setSubject(user.getUsername())
                .claim(multiTenantKey, user.getTenant().getId())
                .signWith(this.secretKey)
                .compact();
    }


    public Claims verifyToken(String token)
    {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(this.secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            if (claims == null) {
                return null;
            }
            String username = claims.getSubject();
            System.out.println(username + " logged in");

            if (claims.getExpiration().before(new Date())) //expired
            {
                return null;
            }
            return claims;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
