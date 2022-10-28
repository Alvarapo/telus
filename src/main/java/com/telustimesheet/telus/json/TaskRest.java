package com.telustimesheet.telus.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class TaskRest implements Serializable {
    private Long id;
    private float duration;
    private Date date;

    public TaskRest() {
        super();
    }

    public TaskRest(Long id, float duration, Date date) {
        super();
        this.id = id;
        this.duration = duration;
        this.date = date;
    }

    public TaskRest(float duration, Date date) {
        super();
        this.duration = duration;
        this.date = date;
    }

}
