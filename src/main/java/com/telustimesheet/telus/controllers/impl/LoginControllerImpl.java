package com.telustimesheet.telus.controllers.impl;


import com.telustimesheet.telus.controllers.LoginController;
import com.telustimesheet.telus.entities.UserEntity;
import com.telustimesheet.telus.services.UserService;
import com.telustimesheet.telus.utils.constants.HTMLConstants;
import com.telustimesheet.telus.utils.constants.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(RestConstants.RESOURCE_AUTH)
public class LoginControllerImpl implements LoginController {
	
	
	@Autowired
	private UserService userService;


	@Override
	@GetMapping(path={RestConstants.RESOURCE_LOGIN})
	public String login(Model model) {
		model.addAttribute("user", new UserEntity());
		return HTMLConstants.RESOURCE_LOG_IN;
	}
	@Override
	@GetMapping(path={RestConstants.RESOURCE_SING_IN})
	public ModelAndView singIn() {
		return new ModelAndView(HTMLConstants.RESOURCE_SING_IN).addObject("userDTO", new UserEntity());
	}
	
	
	

	
}
