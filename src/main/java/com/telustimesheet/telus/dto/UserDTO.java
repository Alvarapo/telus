package com.telustimesheet.telus.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.telustimesheet.telus.entities.RolEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO  implements BaseDTO{
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String password;

    @Column(name="NAME")
    private String name;

    private String email;

    @JsonIgnoreProperties(value="users")
    private List<RolEntity> roles;
}
