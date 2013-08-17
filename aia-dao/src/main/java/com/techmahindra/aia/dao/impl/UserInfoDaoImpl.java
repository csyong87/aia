package com.techmahindra.aia.dao.impl;

import com.techmahindra.aia.dao.UserInfoDao;
import com.techmahindra.aia.model.RoleInfo;
import com.techmahindra.aia.model.UserInfo;
import com.techmahindra.aia.query.QueryBuilder;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 8/17/13
 * Time: 5:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    private QueryBuilder queryBuilder;

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Retrieves the {@link com.techmahindra.aia.model.UserInfo} identified by the parameter <tt>username</tt>
     * <p/>
     *
     * @param username The user's login name
     *
     * @return
     */
    @Override
    public UserInfo getUserInfoByUsername(final String username) {
        //prevent HashMap from allocating the default size by specifying the exact size
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("username", username);

        Query query = queryBuilder.buildQuery(sessionFactory, "UserInfoDao.getUserInfoByUsername", params);
        return (UserInfo) query.uniqueResult();
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
    public List<RoleInfo> getUserRoles(final int userInfoId) {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("userInfoId", userInfoId);

        Query query = queryBuilder.buildQuery(sessionFactory, "UserInfoDao.getUserRoles", params);
        return query.list();
    }
}
