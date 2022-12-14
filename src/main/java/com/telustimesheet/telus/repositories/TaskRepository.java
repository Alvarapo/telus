package com.telustimesheet.telus.repositories;

import com.telustimesheet.telus.entities.TaskEntity;
import com.telustimesheet.telus.repositories.general.ExtendedJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface TaskRepository extends ExtendedJpaRepository<TaskEntity> {

    //@Transactional(readOnly = true)
    @Query(value = "SELECT SUM(t.duration) FROM TASKS t WHERE t.DATE = :date",
            nativeQuery  = true)
    Float getTotalDurationByDate(@Param("date") Date date);

    @Query(value = "SELECT SUM(t.duration) FROM TASKS t WHERE t.DATE BETWEEN :date1 AND :date2",
            nativeQuery  = true)
    Float getTotalDurationBetweenDate(@Param("date1") Date date1, @Param("date2") Date date2);

    @Query(value = "SELECT SUM(duration)\n" +
            "FROM TASKS \n" +
            "WHERE MONTH(date) = :month\n" +
            "GROUP BY MONTH(date);",
            nativeQuery  = true)
    Float getTotalDurationByMonth(@Param("month") int month);

    @Query(value = "SELECT Round((SUM(duration)/60)*9.5,2)\n" +
            "FROM TASKS \n" +
            "WHERE MONTH(date) = :month\n" +
            "GROUP BY MONTH(date);",
            nativeQuery  = true)
    Float getTotalPayrollByMonth(@Param("month") int month);
    /*@Query(value = "SELECT * FROM TASKS WHERE DATE = :date;",
            nativeQuery  = true)*/
    List<TaskEntity> findByDate(/*@Param("date")*/ Date date);
}
