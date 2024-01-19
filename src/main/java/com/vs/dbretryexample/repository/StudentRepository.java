package com.vs.dbretryexample.repository;

import com.vs.dbretryexample.dao.StudentDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentDao, Long> { }
