package com.techmahindra.aia.service.impl;

import com.techmahindra.UnitTestBase;
import com.techmahindra.aia.dao.RoleFunctionAccessDao;
import com.techmahindra.aia.model.FunctionInfo;
import com.techmahindra.aia.model.RoleFunctionAccess;
import com.techmahindra.aia.service.FunctionInfoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 9/5/13
 * Time: 10:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class FunctionInfoServiceImplTest extends UnitTestBase {

    @Autowired
    private FunctionInfoService functionInfoService;

    @Autowired
    private RoleFunctionAccessDao roleFunctionAccessDao;

    /**
     * Will setup the test cases for {@link FunctionInfoService#getFunctions(String)}
     */
    @Before
    public void init() {
        try {
            RoleFunctionAccess rfa = new RoleFunctionAccess();
            rfa.setRoleInfoId(3); //developer role
            rfa.setFunctionInfoId(100); //dashboard menu
            rfa.setCreatedBy("ADMIN");
            rfa.setDateCreated(Calendar.getInstance().getTime());
            rfa.setStatus(RoleFunctionAccess.Status.ACTIVE);
            roleFunctionAccessDao.addRoleFunctionAccess(rfa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Will test against pre defined set of admin functions.
     *
     * @throws Exception
     */
    @Test
    public void testGetAdminFunctions() throws Exception {
        List<FunctionInfo> functionList = functionInfoService.getAdminFunctions();
        Assert.assertNotNull(functionList);
        printFunctions(functionList);

    }

    /**
     * Will test against pre defined set of profile functions.
     *
     * @throws Exception
     */
    @Test
    public void testGetProfileFunctions() throws Exception {
        List<FunctionInfo> functionList = functionInfoService.getProfileFunctions();
        Assert.assertNotNull(functionList);
        printFunctions(functionList);
    }

    @Test
    public void testGetFunctions() throws Exception {
        List<FunctionInfo> functionList = functionInfoService.getFunctions("christian");
        Assert.assertNotNull(functionList);
        printFunctions(functionList);
    }

    private void printFunctions(List<FunctionInfo> rootFunction) {

        for (FunctionInfo f : rootFunction) {
            System.out.println(String.format("Name: %s; Url: %s", f.getName(), f.getUrl()));
            if (f.getChildren() != null) {
                printFunctions(f.getChildren());
            }
        }
    }
}
