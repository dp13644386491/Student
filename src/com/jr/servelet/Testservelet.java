package com.jr.servelet;

import com.jr.biz.impl.StudentBizimpl;
import com.jr.entry.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

@WebServlet("/asd")
public class Testservelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String i = req.getParameter("i");
        if (i == null) {
            register(req, resp);

        }else {
            int num = Integer.parseInt(i);
            if (num == 1) {
                Login(req, resp);
            }else if (num==2){
                showall(req,resp);
            }else  if(num==3){
                delete(req,resp);
            }else  if (num==4) {
                showone(req,resp);
            }else if (num==6){
                update(req,resp);
            }
        }

    }
    public void  register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        int studentid = Integer.parseInt(req.getParameter("studentid"));
        String studentname=req.getParameter("studentname");
        String studentclass=req.getParameter("studentclass");
        StudentBizimpl ddi = new StudentBizimpl();
        Student student = new Student();
        student.setStudentid(studentid);
        student.setStudentname(studentname);
        student.setStudentclass(studentclass);
        boolean boo = ddi.register(student);
        if(boo){
           resp.sendRedirect("Login.jsp");
        }else{
            resp.getWriter().println("注册失败");
        }


    }
    public void Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        int studentid = Integer.parseInt(req.getParameter("studentid"));
        String studentname=req.getParameter("studentname");
        StudentBizimpl ddi = new StudentBizimpl();
        Student student = new Student();
        student.setStudentid(studentid);
        student.setStudentname(studentname);
        boolean boo = ddi.Login(student);
        if(boo){
            resp.getWriter().println("登陆成功");
        }else{
            resp.getWriter().println("登入失败");
        }

    }
    public void  showall(HttpServletRequest req, HttpServletResponse resp){

    }
    public void  delete(HttpServletRequest req, HttpServletResponse resp){

    }
    public void  showone(HttpServletRequest req, HttpServletResponse resp){

    }
    public void  update(HttpServletRequest req, HttpServletResponse resp){

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("236");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
