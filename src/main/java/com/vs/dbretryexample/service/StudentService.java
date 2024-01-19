package com.vs.dbretryexample.service;

import com.vs.dbretryexample.dao.StudentDao;
import com.vs.dbretryexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.RetryConfiguration;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetrySynchronizationManager;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Retryable(include = {SQLException.class}, maxAttempts = 3)
    public StudentDao save(StudentDao studentDao) throws SQLException {
        boolean asd = false;
        try {
            if (asd) {
                throw new SQLException();
            }
        } catch (SQLException sqlException) {
            System.out.println(RetrySynchronizationManager.getContext().getRetryCount());
            sqlException.printStackTrace();
            throw sqlException;
        }
       return studentRepository.save(studentDao);
    }
}
