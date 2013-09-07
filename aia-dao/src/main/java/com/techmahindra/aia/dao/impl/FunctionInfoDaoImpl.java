package com.techmahindra.aia.dao.impl;

import com.techmahindra.aia.dao.FunctionInfoDao;
import com.techmahindra.aia.model.FunctionInfo;
import com.techmahindra.aia.query.QueryBuilder;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation class for the {@link FunctionInfoDao} interface
 */
@Repository
public class FunctionInfoDaoImpl implements FunctionInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private QueryBuilder queryBuilder;

    /**
     * @return The list of {@link com.techmahindra.aia.model.FunctionInfo} which only 'Administrator' users must have
     *         access to
     */
    @Override
    public List<FunctionInfo> getAdminFunctions() {
        Query query = queryBuilder.buildQuery(sessionFactory, "FunctionInfoDao.getAdminFunctions");
        return query.list();
    }

    /**
     * @return The list of {@link com.techmahindra.aia.model.FunctionInfo} which are under 'Profile'
     */
    @Override
    public List<FunctionInfo> getProfileFunctions() {
        Query query = queryBuilder.buildQuery(sessionFactory, "FunctionInfoDao.getProfileFunctions");
        return query.list();
    }

    /**
     * Retrieves the list of {@link com.techmahindra.aia.model.FunctionInfo} whom the {@code username} is mapped to.
     *
     * @param username The name of the user which has the rights to access the functions.
     * @return the list of {@link FunctionInfo} whom the {@code username} is mapped to.
     */
    @Override
    public List<FunctionInfo> getFunctions(final String username) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);

        Query query = queryBuilder.buildQuery(sessionFactory, "FunctionInfoDao.getFunctions", map);
        return query.list();
    }
}
