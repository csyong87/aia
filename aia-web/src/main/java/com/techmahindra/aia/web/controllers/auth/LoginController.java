package com.techmahindra.aia.web.controllers.auth;

import com.techmahindra.aia.web.controllers.ControllerBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * The controller for requests to /login.html.
 * <p/>
 *
 * @author Christian
 */
@Controller
public class LoginController extends ControllerBase {

    private static final Log LOG = LogFactory.getLog(LoginController.class);

    /**
     * The handler method for requests to /login.html
     *
     * @return Either 'login' when user has no active session or 'redirectToMain' when user still has an active session
     */
    @RequestMapping("/login.html")
    public String showLoginPage() {

        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return "login";
        }

        // if we still have an active session, no need to show the login screen
        // redirect back to main landing screen
        return "redirectToMain";
    }
}
