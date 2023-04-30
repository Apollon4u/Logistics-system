package com.example.logisticssystem.utils;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

@UtilityClass
public class JwtUtils {

    public String getKeycloakId() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return null;
        }
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getName();
    }

    public String getUserName() {
        try {
            Jwt credentials = getJwt();
            Object mid = credentials.getClaims().get("preferred_username");
            return (String) mid;
        } catch (Exception e) {
            return getKeycloakId();
        }
    }

    private Jwt getJwt() {
        return (Jwt) SecurityContextHolder.getContext().getAuthentication().getCredentials();
    }

}