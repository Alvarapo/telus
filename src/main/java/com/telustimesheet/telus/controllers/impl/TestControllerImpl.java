package com.telustimesheet.telus.controllers.impl;


import com.telustimesheet.telus.controllers.TestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestControllerImpl implements TestController {


    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
