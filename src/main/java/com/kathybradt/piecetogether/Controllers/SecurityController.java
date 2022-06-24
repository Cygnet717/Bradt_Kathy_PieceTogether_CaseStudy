package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.Service.UserService;
import com.kathybradt.piecetogether.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.plaf.metal.MetalLabelUI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class SecurityController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/userdata", method = RequestMethod.GET)
    @ResponseBody
    public User getCurrentUser(Principal principal){
        String userEmail = principal.getName();
        User currUser = userService.findUserByEmail(userEmail);

        return currUser;
    }


}
