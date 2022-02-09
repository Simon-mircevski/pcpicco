package com.example.pcpicco.model.enumeration;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    CLIENT,
    ADMIN,
    SELLER_ADMIN,
    DISTRIBUTOR;

    @Override
    public String getAuthority() {
        return null;
    }
}
