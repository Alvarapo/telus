package com.telustimesheet.telus.controllers.impl;

import com.telustimesheet.telus.controllers.PrivateController;
import com.telustimesheet.telus.dto.UserDTO;
import com.telustimesheet.telus.exceptions.TelusException;
import com.telustimesheet.telus.services.TaskService;
import com.telustimesheet.telus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/private")
public class PrivateControllerImpl implements PrivateController {

    @Autowired
    private UserService userService;

    @Autowired
    transient TaskService taskService;


    @Override
    @GetMapping(value = "/index")
    public String index(Authentication auth, HttpSession session, Model model ) throws TelusException {
        String username = auth.getName();

        if(session.getAttribute("user")==null) {
            UserDTO user = userService.findByEmail(username);
            user.setPassword(null);
            session.setAttribute("user", user);

        }
        model.addAttribute("tasks",taskService.getTasks());
        return "index";
    }
}
