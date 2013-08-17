package com.techmahindra.aia.dao;

import com.techmahindra.aia.model.RoleInfo;
import com.techmahindra.aia.model.UserInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 8/17/13
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserInfoDao {

    /**
     * Retrieves the {@link UserInfo} identified by the parameter <tt>username</tt>
     * <p/>
     *
     * @param username The user's login name
     *
     * @return
     */
    UserInfo getUserInfoByUsername(String username);

    /**
     * Retrieves the <tt>userInfoId</tt> roles
     * <p/>
     *
     * @param userInfoId
     *
     * @return
     */
    List<RoleInfo> getUserRoles(int userInfoId);
}
