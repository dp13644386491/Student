package com.jr.dao;

import com.jr.entry.Student;

import java.util.List;

public interface StudentDao {
    public  int register(Student student);
    public  Student Login(Student student);
    public List<Student> showall();
    public  Student showone(Student student);
    public  int update(Student student);
    public  int delet(Student student);
}
