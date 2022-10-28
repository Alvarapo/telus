package com.telustimesheet.telus.repositories;

import com.telustimesheet.telus.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

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
    List<Task> findByDate(/*@Param("date")*/ Date date);
}
