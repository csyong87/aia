package com.techmahindra.aia.dao;

import com.techmahindra.aia.model.FunctionInfo;

import java.util.List;

/**
 * The interface which defines the methods for working with menu functions
 * <p/>
 *
 * @author Christian
 */
public interface FunctionInfoDao {

    // ~ System Functions =====================================================

    /**
     * @return The list of {@link FunctionInfo} which only 'Administrator' users must have access to
     */
    List<FunctionInfo> getAdminFunctions();

    /**
     * @return The list of {@link FunctionInfo} which are under 'Profile'
     */
    List<FunctionInfo> getProfileFunctions();

    // ~ Customisable Functions =====================================================

    /**
     * Retrieves the list of {@link FunctionInfo} whom the {@code username} is mapped to.
     *
     * @param username The name of the user which has the rights to access the functions.
     * @return the list of {@link FunctionInfo} whom the {@code username} is mapped to.
     */
    List<FunctionInfo> getFunctions(String username);
}
