package com.techmahindra.aia.web.security;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.techmahindra.aia.model.UserInfo;
import com.techmahindra.aia.service.UserInfoService;
import com.techmahindra.aia.service.model.UserContext;
import com.techmahindra.aia.web.datastore.DataStore;

/**
 * <p>
 * An AIA implementation of {@link AuthenticationSuccessHandler}. This class is called by the Spring Security Framework
 * right after successful authentication.
 * </p>
 * 
 * @author Christian
 * 
 */
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    // ~ Field Instance =============================================

    @Autowired
    private DataStore dataStore;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * Constructor which sets the <tt>defaultTargetUrl</tt> property of the base class.
     * 
     * @param defaultTargetUrl
     *            the URL to which the user should be redirected on successful authentication.
     */
    public AuthSuccessHandler(final String defaultTargetUrl) {
        setDefaultTargetUrl(defaultTargetUrl);
    }

    /**
     * Invokes the configured {@code RedirectStrategy} with the URL returned by the {@code determineTargetUrl} method.
     * <p>
     * The redirect will not be performed if the response has already been committed.
     *
     * @param request The http request object
     * @param response The http response object
     * @param authentication The user's authentication principal
     *
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String targetUrl = determineTargetUrl(request, response);

        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // get the user's info object
        UserInfo userInfo = userInfoService.getUserInfoByUsername(auth.getName());

        // initialize the logged in user's context data
        UserContext userContextData = new UserContext(userInfo);

        logger.info(String.format("User: %s; Logged-in at: %s", userInfo.getUsername(), Calendar.getInstance()
                .getTime()));

        // store the user's context data into the session-maintained dataStore
        dataStore.setUserContextData(userContextData);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
