package com.techmahindra.aia.service.impl;

import com.techmahindra.aia.dao.UserInfoDao;
import com.techmahindra.aia.model.RoleInfo;
import com.techmahindra.aia.model.UserInfo;
import com.techmahindra.aia.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 8/17/13
 * Time: 11:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * Retrieves the {@link com.techmahindra.aia.model.UserInfo} identified by the parameter <tt>username</tt>
     * <p/>
     *
     * @param username The user's login name
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public UserInfo getUserInfoByUsername(final String username) {
        return userInfoDao.getUserInfoByUsername(username);
    }

    /**
     * Retrieves the <tt>userInfoId</tt> roles
     * <p/>
     *
     * @param userInfoId
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<RoleInfo> getUserRoles(final int userInfoId) {
        return userInfoDao.getUserRoles(userInfoId);
    }
}
