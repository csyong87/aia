package com.techmahindra.aia.dao.impl;

import com.techmahindra.aia.dao.RoleFunctionAccessDao;
import com.techmahindra.aia.model.RoleFunctionAccess;
import com.techmahindra.aia.query.QueryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 9/6/13
 * Time: 8:40 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class RoleFunctionAccessDaoImpl implements RoleFunctionAccessDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private QueryBuilder queryBuilder;

    /**
     * Creates a new {@link com.techmahindra.aia.model.RoleFunctionAccess}
     *
     * @param roleFunctionAccess The new {@link com.techmahindra.aia.model.RoleFunctionAccess} to create
     */
    @Override
    public void addRoleFunctionAccess(final RoleFunctionAccess roleFunctionAccess) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(roleFunctionAccess);
    }

    /**
     * The {@link com.techmahindra.aia.model.RoleFunctionAccess} to update identified by {@link com.techmahindra.aia.model.RoleFunctionAccess#getRoleFunctionAccessId()}
     *
     * @param roleFunctionAccess The new {@link com.techmahindra.aia.model.RoleFunctionAccess} to update
     */
    @Override
    public void updateRoleFunctionAcces(final RoleFunctionAccess roleFunctionAccess) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(roleFunctionAccess);
    }
}
