package com.techmahindra.aia.web.controllers.main;

import com.techmahindra.aia.constants.Constants;
import com.techmahindra.aia.model.FunctionInfo;
import com.techmahindra.aia.service.FunctionInfoService;
import com.techmahindra.aia.web.controllers.ControllerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Christian
 */
@Controller
public class MainLandingController extends ControllerBase {

    @Autowired
    private FunctionInfoService functionInfoService;

    /**
     * A noop controller handler which redirects to the main landing page.
     *
     * @param session The {@link HttpSession}
     * @return main
     */
    @RequestMapping("/main.html")
    public final String handleMainLanding(HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // The common functions, every authenticated user will have this one
        List<FunctionInfo> profileFunctions = functionInfoService.getProfileFunctions();
        session.setAttribute("profile", profileFunctions);

        //check if the logged in user has an admin role
        for (GrantedAuthority ga : auth.getAuthorities()) {
            if (ga.getAuthority().equalsIgnoreCase(Constants.ROLE_ADMIN)) {
                //if user has an admin role
                List<FunctionInfo> adminFunctions = functionInfoService.getAdminFunctions();
                session.setAttribute("adminFunctions", adminFunctions);
            }
        }

        // Functions specific to this user who's been mapped to those roles
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        List<FunctionInfo> workFunctions = functionInfoService.getFunctions(userDetails.getUsername());
        session.setAttribute("workFunctions", workFunctions);

        return "main";
    }
}
