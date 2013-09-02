package com.techmahindra.aia.web.controllers.main;

import com.techmahindra.aia.web.controllers.ControllerBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Christian
 */
@Controller
public class MainLandingController extends ControllerBase {

    /**
     * A noop controller handler which redirects to the main landing page.
     *
     * @return main
     */
    @RequestMapping("/main.html")
    public final String handleMainLanding() {
        // NOOP
        return "main";
    }
}
