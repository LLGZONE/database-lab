package com.llgzone.market.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

public class JWTAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final Object principal;
    private final Object credentials;
    
    public JWTAuthenticationToken(String token) {
        super(null);
        this.principal = null;
        this.credentials = token;
        setAuthenticated(false);
    }

    /**
     * 鉴定成功后调用的方法，返回的JWTAuthenticationToken供Controller里面调用。
     * 因为已经鉴定成功，所以要setAuthenticated(true)
     */
    public JWTAuthenticationToken(String token, Object userInfo, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = userInfo;
        this.credentials = token;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}