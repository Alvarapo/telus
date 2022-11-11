package com.telustimesheet.telus.controllers;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface LoginController {
    public String login(Model model);
    public ModelAndView singIn();
}
