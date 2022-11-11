package com.telustimesheet.telus.controllers;

import com.telustimesheet.telus.exceptions.TelusException;
import org.springframework.ui.Model;

public interface BasicController {
    public String index(Model model) throws TelusException;
    public String tasks(Model model) throws TelusException ;
    public String newTask(Model model) throws TelusException ;
}
