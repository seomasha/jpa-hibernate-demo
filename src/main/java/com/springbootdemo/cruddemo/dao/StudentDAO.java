package com.springbootdemo.cruddemo.dao;

import com.springbootdemo.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    List<Student> findAll();
    Student findByID(Integer id);
}
