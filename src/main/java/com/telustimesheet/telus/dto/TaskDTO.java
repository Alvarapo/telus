package com.telustimesheet.telus.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO implements BaseDTO{

    private static final long serialVersionUID = 1L;

    private Long id;

    private float duration;

    private Date date;

    @JsonIgnoreProperties(value="tasks")
    private UserDTO user;

    public TaskDTO(float duration, Date date) {
        this.duration = duration;
        this.date = date;
    }
}
