package com.telustimesheet.telus.controllers.impl;


import com.telustimesheet.telus.entities.UserEntity;
import com.telustimesheet.telus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/auth")
public class LoginControllerImpl {
	
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(path={"/login"})
	public String login(Model model) {
		model.addAttribute("user", new UserEntity());
		return "/html/login";
	}
	
	/*@GetMapping(path={"/singIn"})
	public ModelAndView singIn() {
		
		return new ModelAndView("/HTML/registro").addObject("usuario", new UsuarioEntity());
	}*/
	
	
	

	
}
