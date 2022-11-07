package com.telustimesheet.telus.repositories.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ExtendedJpaRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}