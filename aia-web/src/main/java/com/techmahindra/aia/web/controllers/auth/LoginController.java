package com.techmahindra.aia.web.controllers.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techmahindra.aia.web.controllers.ControllerBase;
import com.techmahindra.aia.web.datastore.DataStore;

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

    /**
     * The handler method for requests to /login.html
     * 
     * @return
     */
    @RequestMapping("/login.html")
    public String showLoginPage() {
        // Check if still have an active session
        DataStore dataStore = getDataStore();
        if (dataStore == null || dataStore.getUserContextData() == null)
            return "login";

        LOG.info(String.format("User %s still has an active session", dataStore.getUserContextData().getUserInfo()
                .getUsername()));

        // if we still have an active session, no need to show the login screen
        // redirect back to main landing screen
        return "redirectToMain";
    }
}
