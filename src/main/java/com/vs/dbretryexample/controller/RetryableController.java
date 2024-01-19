package com.vs.dbretryexample.controller;

import com.vs.dbretryexample.dao.StudentDao;
import com.vs.dbretryexample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class RetryableController {

    @Autowired
    StudentService studentService;
    @PostMapping(path = "/student", produces = "application/json", consumes = "application/json")
    public ResponseEntity<StudentDao> createStudent(@RequestBody StudentDao studentDao) throws SQLException {
        StudentDao studentDao1 = studentService.save(studentDao);
        return new ResponseEntity<>(studentDao1, HttpStatus.CREATED);
    }
}
