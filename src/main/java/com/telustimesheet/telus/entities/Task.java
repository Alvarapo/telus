package com.telustimesheet.telus.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "TASKS")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter Long id;

    @Column(name = "duration")
    private float duration;

    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", updatable = false, referencedColumnName = "IDUSER")
    @JsonIgnoreProperties(value = "tasks")
    private User user;

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
