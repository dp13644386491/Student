package com.jr.entry;

public class Student {
    private int studentid;
    private String studentname;
    private String studentclass;

    public Student(int studentid, String studentname, String studentclass) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.studentclass = studentclass;
    }

    public Student() {
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentclass() {
        return studentclass;
    }

    public void setStudentclass(String studentclass) {
        this.studentclass = studentclass;
    }

    @Override
    public String toString() {
        return
                studentid +'\'' +
               studentname + '\'' +
                 studentclass + '\''
                ;
    }
}
