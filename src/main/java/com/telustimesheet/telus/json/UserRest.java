package com.telustimesheet.telus.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserRest implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    //private List<Rol> roles;
}
