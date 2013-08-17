package com.techmahindra.aia.service.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 8/17/13
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDetailsImpl implements UserDetails {

    // ~ Instance Variables =================================================
    private Collection<GrantedAuthority> authorities;

    private String password;

    private String username;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

    /**
     * Creates a new {@link UserDetails} object with the values specified in the constructor's parameters
     *
     * @param authorities
     * @param password
     * @param username
     * @param accountNonExpired
     * @param accountNonLocked
     * @param credentialsNonExpired
     * @param enabled
     */
    public UserDetailsImpl(final Collection<GrantedAuthority> authorities, final String password, final String username,
                           final boolean accountNonExpired, final boolean accountNonLocked,
                           final boolean credentialsNonExpired, final boolean enabled) {
        this.authorities = authorities;
        this.password = password;
        this.username = username;
        isAccountNonExpired = accountNonExpired;
        isAccountNonLocked = accountNonLocked;
        isCredentialsNonExpired = credentialsNonExpired;
        isEnabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
