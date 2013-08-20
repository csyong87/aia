package com.techmahindra.aia.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.techmahindra.aia.model.RoleInfo;
import com.techmahindra.aia.model.UserInfo;
import com.techmahindra.aia.service.UserInfoService;

/**
 * Created with IntelliJ IDEA. User: Christian Date: 8/17/13 Time: 5:31 PM To change this template use File | Settings |
 * File Templates.
 */
@Configurable
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(final String s) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoService.getUserInfoByUsername(s);
        if (userInfo == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", s));
        }

        List<RoleInfo> roleInfoList = userInfoService.getUserRoles(userInfo.getUserInfoId());
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(roleInfoList.size());
        for (RoleInfo roleInfo : roleInfoList) {
            GrantedAuthority ga = new SimpleGrantedAuthority(String.format("ROLE_%s", roleInfo.getName()));
            authorities.add(ga);
        }
        return new UserDetailsImpl(authorities, userInfo.getPassword(), s, true, true, true, true);
    }
}
