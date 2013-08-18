package com.techmahindra.aia.web.controllers.auth;

import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techmahindra.aia.web.controllers.ControllerBase;

/**
 * The controller for requests to /login.html
 * <p/>
 * 
 * @author Christian
 * 
 */
@Controller
public class LoginController extends ControllerBase {

    private static final Log LOG = LogFactory.getLog(LoginController.class);

    @RequestMapping("/login.html")
    public String showLoginPage() {
        LOG.info(String.format("LoginController#showLoginPage called at %s", Calendar.getInstance().getTime()));

        return "login";
    }
}
