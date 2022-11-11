package com.telustimesheet.telus.controllers;

import com.telustimesheet.telus.exceptions.TelusException;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface PrivateController {
    public String index(Authentication auth, HttpSession session, Model model ) throws TelusException;
}
