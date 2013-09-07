package com.techmahindra.aia.dao;

import com.techmahindra.aia.model.RoleFunctionAccess;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 9/6/13
 * Time: 8:37 AM
 * To change this template use File | Settings | File Templates.
 */
public interface RoleFunctionAccessDao {

    /**
     * Creates a new {@link RoleFunctionAccess}
     *
     * @param roleFunctionAccess The new {@link RoleFunctionAccess} to create
     */
    void addRoleFunctionAccess(RoleFunctionAccess roleFunctionAccess);

    /**
     * The {@link RoleFunctionAccess} to update identified by {@link RoleFunctionAccess#getRoleFunctionAccessId()}
     *
     * @param roleFunctionAccess The new {@link RoleFunctionAccess} to update
     */
    void updateRoleFunctionAcces(RoleFunctionAccess roleFunctionAccess);
}
