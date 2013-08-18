package com.techmahindra.aia.service.model;

import java.io.Serializable;

import com.techmahindra.aia.model.UserInfo;

/**
 * Preserve's the logged in user's context data
 * <p/>
 * 
 * @author Christian
 * 
 */
public class UserContext implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4007890136876242669L;

    private UserInfo userInfo;

    public UserContext(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * @return the userInfo
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

}
