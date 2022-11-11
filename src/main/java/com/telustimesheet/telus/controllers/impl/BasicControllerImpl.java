package com.telustimesheet.telus.controllers.impl;

import com.telustimesheet.telus.controllers.BasicController;
import com.telustimesheet.telus.dto.TaskDTO;
import com.telustimesheet.telus.exceptions.TelusException;
import com.telustimesheet.telus.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class BasicControllerImpl implements BasicController {

    @Autowired
    transient TaskService taskService;

    @Override
    @GetMapping()
    public String index(Model model) throws TelusException {
        model.addAttribute("tasks",taskService.getTasks());
        return "index";
    }

    @Override
    @GetMapping(path={"/tasks"})
    public String tasks(Model model) throws TelusException{
        model.addAttribute("tasks",taskService.getTasks());
        return "/html/show-tasks";
    }

    @Override
    @GetMapping(path={"/new-task"})
    public String newTask(Model model) throws TelusException{
        model.addAttribute("tasks", new TaskDTO());
        return "/html/new-task";
    }
}
