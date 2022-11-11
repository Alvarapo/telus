package com.telustimesheet.telus.controllers.impl;


import com.telustimesheet.telus.config.responses.TelusResponse;
import com.telustimesheet.telus.controllers.UserController;
import com.telustimesheet.telus.dto.UserDTO;
import com.telustimesheet.telus.exceptions.TelusException;
import com.telustimesheet.telus.services.UserService;
import com.telustimesheet.telus.utils.constants.CommonConstants;
import com.telustimesheet.telus.utils.constants.RedirectConstant;
import com.telustimesheet.telus.utils.constants.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(RestConstants.RESOURCE_USERS)
public class UserControllerImpl implements UserController {
    @Autowired
    transient UserService userService;


    @Override
    @PostMapping(value = RestConstants.RESOURCE_SING_IN)
    public String singInUser(UserDTO userDTO, RedirectAttributes flash) {
        try {
            UserDTO newUserDTO = userService.singInUser(userDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        flash.addFlashAttribute("success", "¡Registro realizado con éxito!");
        return RedirectConstant.REDIRECT_LOGIN;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public TelusResponse<List<UserDTO>> getAllUsers() throws TelusException {
        return new TelusResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                userService.getAllUsers());
    }


}
