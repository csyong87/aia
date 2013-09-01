package com.techmahindra.aia.web.controllers.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techmahindra.aia.web.controllers.ControllerBase;

/**
 * 
 * 
 * @author Christian
 * 
 */
@Controller
public class MainLandingController extends ControllerBase {

    @RequestMapping("/main.html")
    public String handleMainLanding() {
        // NOOP
        return "main";
    }
}
