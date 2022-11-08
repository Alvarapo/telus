package com.telustimesheet.telus.services.impl;

import com.telustimesheet.telus.dto.UserDTO;
import com.telustimesheet.telus.entities.RolEntity;
import com.telustimesheet.telus.entities.UserEntity;
import com.telustimesheet.telus.exceptions.TelusException;
import com.telustimesheet.telus.repositories.UserRepository;
import com.telustimesheet.telus.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    transient UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public UserDTO singInUser(UserDTO userDTO) throws TelusException {
        String encodedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());

        UserEntity newUserEntity = new UserEntity();
        newUserEntity.setPassword(encodedPassword);
        newUserEntity.setUsername(userDTO.getUsername());
        newUserEntity.setPassword(encodedPassword);
        newUserEntity.setName(userDTO.getName());
        newUserEntity.setEmail(userDTO.getEmail());

        List<RolEntity> roles= new ArrayList<>();

        RolEntity rolEntity = new RolEntity();
        rolEntity.setId(2L);
        roles.add(rolEntity);

        newUserEntity.setRoles(roles);

        newUserEntity = userRepository.save(newUserEntity);

        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() throws TelusException {
        return userRepository.findAll().stream().map(users -> modelMapper.map(users, UserDTO.class))
                .collect(Collectors.toList());
    }
}
