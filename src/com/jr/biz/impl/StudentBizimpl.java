package com.jr.biz.impl;

import com.jr.biz.StudentBiz;
import com.jr.dao.impl.StudentDaoimpl;
import com.jr.entry.Student;

import java.util.List;

public class StudentBizimpl implements StudentBiz {
    StudentDaoimpl stu=new StudentDaoimpl();
    @Override
    public boolean register(Student student) {
        return stu.register(student)==0?false:true;
    }

    @Override
    public boolean Login(Student student) {
        return stu.Login(student)==null?false:true;
    }

    @Override
    public List<Student> showall() {
        return stu.showall();
    }

    @Override
    public Student showone(Student student) {
        return stu.showone(student);
    }

    @Override
    public boolean update(Student student) {
        return stu.update(student)==0?false:true;
    }

    @Override
    public boolean delet(Student student) {
        return stu.delet(student)==0?false:true;
    }
}
