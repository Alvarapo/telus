package com.telustimesheet.telus.services;

import com.telustimesheet.telus.exceptions.TelusException;
import com.telustimesheet.telus.json.TaskRest;

import java.sql.Date;
import java.util.List;

public interface TaskService {
    List<TaskRest> getTasks() throws TelusException;

    Float getTotalDurationByDate(Date date) throws TelusException;

    Float getTotalDurationBetweenDate(Date date1, Date date2) throws TelusException;

    Float getTotalDurationByMonth(int month) throws TelusException;

    Float getTotalPayrollByMonth(int month) throws TelusException;

    Float getTotalIRPFByMonth(int month) throws TelusException;

    TaskRest addTask(float duration, Date date) throws TelusException;

    TaskRest deleteTask(Long id) throws TelusException;

    List<TaskRest> getTasksByDate(Date date) throws TelusException;
}
