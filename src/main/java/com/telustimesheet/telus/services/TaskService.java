package com.telustimesheet.telus.services;

import com.telustimesheet.telus.dto.TaskDTO;
import com.telustimesheet.telus.exceptions.TelusException;

import java.sql.Date;
import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasks() throws TelusException;

    Float getTotalDurationByDate(Date date) throws TelusException;

    Float getTotalDurationBetweenDate(Date date1, Date date2) throws TelusException;

    Float getTotalDurationByMonth(int month) throws TelusException;

    Float getTotalPayrollByMonth(int month) throws TelusException;

    Float getTotalIRPFByMonth(int month) throws TelusException;

    TaskDTO addTask(float duration, Date date) throws TelusException;

    TaskDTO deleteTask(Long id) throws TelusException;

    List<TaskDTO> getTasksByDate(Date date) throws TelusException;
}
