package com.techmahindra.aia.service.security.test;

import com.techmahindra.UnitTestBase;
import com.techmahindra.aia.service.security.UserDetailServiceImpl;
import org.junit.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 8/17/13
 * Time: 10:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDetailServiceImplTest extends UnitTestBase {

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsernameTest() {
        UserDetailServiceImpl serviceImpl = new UserDetailServiceImpl();
        serviceImpl.loadUserByUsername("unknown_user");
    }
}
