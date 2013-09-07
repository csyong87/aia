package com.techmahindra.aia.service;

import com.techmahindra.aia.model.FunctionInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 9/5/13
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
public interface FunctionInfoService {

    /**
     * @return The list of {@link com.techmahindra.aia.model.FunctionInfo} which only 'Administrator' users must
     *         have access to
     */
    List<FunctionInfo> getAdminFunctions();

    /**
     * @return The list of {@link FunctionInfo} which are under 'Profile'
     */
    List<FunctionInfo> getProfileFunctions();

    // ~ Customisable Functions =====================================================

    /**
     * Retrieves the the list of {@link FunctionInfo} whom the {@code username} has access to
     *
     * @param username The name of the user which has the rights to access the functions.
     * @return the list of {@link FunctionInfo} whom the {@code username} has access to
     */
    List<FunctionInfo> getFunctions(String username);
}
