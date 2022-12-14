package com.telustimesheet.telus.services.impl;

import com.telustimesheet.telus.dto.TaskDTO;
import com.telustimesheet.telus.entities.TaskEntity;
import com.telustimesheet.telus.exceptions.NotFoundException;
import com.telustimesheet.telus.exceptions.NotValidMonth;
import com.telustimesheet.telus.exceptions.TelusException;
import com.telustimesheet.telus.repositories.TaskRepository;
import com.telustimesheet.telus.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    transient TaskRepository taskRepository;

    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<TaskDTO> getTasks() throws TelusException {
        try {
            return taskRepository.findAll().stream().map(taskEntity -> modelMapper.map(taskEntity, TaskDTO.class))
                    .collect(Collectors.toList());
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new NotFoundException(entityNotFoundException.getMessage());
        }
    }

    @Override
    public Float getTotalDurationByDate(Date date) throws TelusException {
        try {
            return taskRepository.getTotalDurationByDate(date);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new NotFoundException(entityNotFoundException.getMessage());
        }
    }

    @Override
    public Float getTotalDurationBetweenDate(Date date1, Date date2) throws TelusException{
        try {
            return taskRepository.getTotalDurationBetweenDate(date1,date2);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new NotFoundException(entityNotFoundException.getMessage());
        }
    }

    @Override
    public Float getTotalDurationByMonth(int month) throws TelusException {
        if(month >= 1 && month <= 12){
            try {
                Float result = taskRepository.getTotalDurationByMonth(month);
                if (result == null){
                    result = 0.0f;
                }
                return result;
            } catch (EntityNotFoundException entityNotFoundException) {
                throw new NotFoundException(entityNotFoundException.getMessage());
            }
        }else{
            throw new NotValidMonth("The month selected is not valid (1 to 12)");
        }

    }

    @Override
    public Float getTotalPayrollByMonth(int month) throws TelusException {
            return (getTotalDurationByMonth(month)/60) * 9.50f;
    }

    @Override
    public Float getTotalIRPFByMonth(int month) throws TelusException {
        return getTotalPayrollByMonth(month) * 0.2f;
    }

    @Override
    public TaskDTO addTask(float duration, Date date) throws TelusException {
        try {
            return modelMapper.map(
                    taskRepository.save(modelMapper.map(new TaskEntity(duration, date), TaskEntity.class)),
                    TaskDTO.class);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new NotFoundException(entityNotFoundException.getMessage());
        }
    }

    @Override
    public TaskDTO deleteTask(Long id) throws TelusException {
        try {
            TaskEntity delete_taskEntity = modelMapper.map(taskRepository.findById(id), TaskEntity.class);
            TaskDTO taskDTO = new TaskDTO(delete_taskEntity.getDuration(), delete_taskEntity.getDate());

            taskRepository.deleteById(id);
            return taskDTO;
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new NotFoundException(entityNotFoundException.getMessage());
        }
    }

    @Override
    public List<TaskDTO> getTasksByDate(Date date) throws TelusException {
        try {
            return taskRepository.findByDate(date).stream().map(taskEntity -> modelMapper.map(taskEntity, TaskDTO.class))
                    .collect(Collectors.toList());
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new NotFoundException(entityNotFoundException.getMessage());
        }
    }

}
