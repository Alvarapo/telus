package com.telustimesheet.telus.controllers;

import com.telustimesheet.telus.config.responses.TelusResponse;
import com.telustimesheet.telus.dto.TaskDTO;
import com.telustimesheet.telus.exceptions.TelusException;

import java.sql.Date;
import java.util.List;

public interface TaskController {
    TelusResponse<List<TaskDTO>> getTasks() throws TelusException;
    TelusResponse<List<TaskDTO>> getTasksByDate(Date date) throws TelusException;

    TelusResponse<Float> getTotalDurationByDate(Date date) throws TelusException;

    TelusResponse<Float> getTotalDurationBetweenDate(Date date1, Date date2) throws TelusException;

    TelusResponse<Float> getTotalDurationByMonth(int month) throws TelusException;

    TelusResponse<Float> getTotalPayrollByMonth(int month) throws TelusException;

    TelusResponse<Float> getTotalIRPFByMonth(int month) throws TelusException;

    TelusResponse<TaskDTO> addTask(float duration, Date date) throws TelusException;

    TelusResponse<TaskDTO> deleteTask(Long id) throws TelusException;
}
