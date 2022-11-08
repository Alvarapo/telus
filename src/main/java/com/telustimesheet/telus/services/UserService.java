package com.telustimesheet.telus.services;

import com.telustimesheet.telus.dto.UserDTO;
import com.telustimesheet.telus.exceptions.TelusException;

import java.util.List;

public interface UserService {
    UserDTO singInUser(UserDTO userDTO) throws TelusException;

    List<UserDTO> getAllUsers() throws TelusException;
}
