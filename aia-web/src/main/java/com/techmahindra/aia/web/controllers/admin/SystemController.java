package com.techmahindra.aia.web.controllers.admin;

import com.techmahindra.aia.web.controllers.ControllerBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Christian
 */
@Controller
public class SystemController extends ControllerBase {

    /**
     * @return
     */
    @RequestMapping("/system.html")
    public String showSystemSettings() {

        return "system";
    }
}
