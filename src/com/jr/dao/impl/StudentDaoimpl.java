package com.jr.dao.impl;
import com.jr.dao.StudentDao;
import com.jr.entry.Student;
import com.jr.until.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoimpl implements StudentDao {
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    Student student1=null;

    @Override
    public int register(Student student) {
        String sql = "insert into student values(?,?,?)";
        return upd(sql, student.getStudentid(), student.getStudentname(),student.getStudentclass());
    }

    @Override
    public Student Login(Student student) {
        String sql = "SELECT * FROM student WHERE studentid=? and studentname=?";
        try {
            con=DBHelper.getconn();
            ps=con.prepareStatement(sql);
            ps.setInt(1,student.getStudentid());
            ps.setString(2,student.getStudentname());
            rs=ps.executeQuery();
            while (rs.next()){
                student1=new Student();
                student1.setStudentid(rs.getInt(1));
                student1.setStudentname(rs.getString(2));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        return student1;
    }

    @Override
    public List<Student> showall() {
        return null;
    }

    @Override
    public Student showone(Student student) {
        return null;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public int delet(Student student) {
        return 0;
    }
    public int upd(String sql,Object...objs){

        int num=0;
        try {
            con= DBHelper.getconn();
            ps=con.prepareStatement(sql);
            for(int i=0;i<objs.length;i++){
                ps.setObject(i+1,objs[i]);
            }
            num= ps.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,con);
        }
        return num;
    }
}
