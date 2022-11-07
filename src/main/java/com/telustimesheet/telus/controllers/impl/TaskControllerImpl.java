package com.telustimesheet.telus.controllers.impl;

import com.telustimesheet.telus.config.responses.TelusResponse;
import com.telustimesheet.telus.controllers.TaskController;
import com.telustimesheet.telus.dto.TaskDTO;
import com.telustimesheet.telus.exceptions.TelusException;
import com.telustimesheet.telus.services.TaskService;
import com.telustimesheet.telus.utils.constants.CommonConstants;
import com.telustimesheet.telus.utils.constants.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@RestController
@RequestMapping(RestConstants.RESOURCE_TASKS)
public class TaskControllerImpl implements TaskController {

    @Autowired
    private TaskService taskService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TelusResponse<List<TaskDTO>> getTasks() throws TelusException {
        return new TelusResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                taskService.getTasks());
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_TASKS +  RestConstants.RESOURCE_DATE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TelusResponse<List<TaskDTO>> getTasksByDate(@PathVariable Date date) throws TelusException {
        return new TelusResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                taskService.getTasksByDate(date));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_DATE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TelusResponse<Float> getTotalDurationByDate(@PathVariable Date date) throws TelusException{
        return new TelusResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                taskService.getTotalDurationByDate(date));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_BETWEEN_DATE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TelusResponse<Float> getTotalDurationBetweenDate(@PathVariable Date date1, @PathVariable Date date2) throws TelusException {
        return new TelusResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                taskService.getTotalDurationBetweenDate(date1,date2));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_YEAR_RESUME + RestConstants.RESOURCE_TOTAL_DURATION + RestConstants.RESOURCE_BY_MONTH, produces = MediaType.APPLICATION_JSON_VALUE)
    public TelusResponse<Float> getTotalDurationByMonth(@PathVariable int month) throws TelusException {
        return new TelusResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                taskService.getTotalDurationByMonth(month));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_YEAR_RESUME + RestConstants.RESOURCE_TOTAL_PAYROLL + RestConstants.RESOURCE_BY_MONTH, produces = MediaType.APPLICATION_JSON_VALUE)
    public TelusResponse<Float> getTotalPayrollByMonth(@PathVariable int month) throws TelusException {
        return new TelusResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                taskService.getTotalPayrollByMonth(month));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_YEAR_RESUME + RestConstants.RESOURCE_TOTAL_IRPF + RestConstants.RESOURCE_BY_MONTH, produces = MediaType.APPLICATION_JSON_VALUE)
    public TelusResponse<Float> getTotalIRPFByMonth(@PathVariable int month) throws TelusException {
        return new TelusResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                taskService.getTotalIRPFByMonth(month));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = RestConstants.RESOURCE_DATE + RestConstants.RESOURCE_DURATION, produces = MediaType.APPLICATION_JSON_VALUE)
    public TelusResponse<TaskDTO> addTask(@PathVariable float duration, @PathVariable Date date) throws TelusException {
        return new TelusResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                taskService.addTask(duration, date));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public TelusResponse<TaskDTO> deleteTask(@PathVariable Long id) throws TelusException {
        return new TelusResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                taskService.deleteTask(id));
    }

}
