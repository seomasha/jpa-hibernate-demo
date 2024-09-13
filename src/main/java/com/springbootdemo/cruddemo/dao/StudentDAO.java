package com.springbootdemo.cruddemo.dao;

import com.springbootdemo.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student student);
    Student findByID(Integer id);
}
