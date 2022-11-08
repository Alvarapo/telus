package com.telustimesheet.telus.controllers;

import com.telustimesheet.telus.config.responses.TelusResponse;
import com.telustimesheet.telus.dto.UserDTO;
import com.telustimesheet.telus.exceptions.TelusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface UserController {

    public String singInUser(UserDTO userDTO, RedirectAttributes flash);

    public TelusResponse<List<UserDTO>> getAllUsers() throws TelusException;

}
