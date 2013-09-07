package com.techmahindra.aia.service.impl;

import com.techmahindra.aia.dao.FunctionInfoDao;
import com.techmahindra.aia.model.FunctionInfo;
import com.techmahindra.aia.service.FunctionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The implementation class {@link FunctionInfoServiceImpl}
 */
@Service
public class FunctionInfoServiceImpl implements FunctionInfoService {

    @Autowired
    private FunctionInfoDao functionInfoDao;

    /**
     * @return The list of {@link com.techmahindra.aia.model.FunctionInfo} which only 'Administrator' users must
     *         have access to
     */
    @Override
    @Transactional(readOnly = true)
    public List<FunctionInfo> getAdminFunctions() {
        return functionInfoDao.getAdminFunctions();
    }

    /**
     * @return The list of {@link com.techmahindra.aia.model.FunctionInfo} which are under 'Profile'
     */
    @Override
    @Transactional(readOnly = true)
    public List<FunctionInfo> getProfileFunctions() {
        return functionInfoDao.getProfileFunctions();
    }

    /**
     * Retrieves the the list of {@link com.techmahindra.aia.model.FunctionInfo} whom the {@code username} has access to
     *
     * @param username The name of the user which has the rights to access the functions.
     * @return the list of {@link com.techmahindra.aia.model.FunctionInfo} whom the {@code username} has access to
     */
    @Override
    @Transactional(readOnly = true)
    public List<FunctionInfo> getFunctions(final String username) {
        return functionInfoDao.getFunctions(username);
    }
}
