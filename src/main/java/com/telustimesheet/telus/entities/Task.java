package com.telustimesheet.telus.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name = "TASKS")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter Long id;

    @Column(name = "duration")
    private float duration;

    @Column(name = "date")
    private Date date;

    public Task(Long id, float duration, Date date){
        super();
        this.id = id;
        this.duration = duration;
        this.date = date;
    }

    public Task(float duration, Date date){
        super();
        this.duration = duration;
        this.date = date;
    }


    public Task(){
        super();
    }
}
