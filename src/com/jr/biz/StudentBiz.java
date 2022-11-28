package com.jr.biz;

import com.jr.entry.Student;

import java.util.List;

public interface StudentBiz {
    public boolean register(Student student);
    public  boolean Login(Student student);
    public List<Student> showall( );
    public  Student showone(Student student);
    public  boolean update(Student student);
    public  boolean delet(Student student);
}
