package com.jr.servelet;

import com.jr.biz.impl.StudentBizimpl;
import com.jr.entry.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;

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

        } else {
            int num = Integer.parseInt(i);
            if (num == 1) {
                Login(req, resp);
            } else if (num == 2) {
                showall(req, resp);
            } else if (num == 3) {
                delete(req, resp);
            } else if (num == 4) {
                showone(req, resp);
            } else if (num == 6) {
                update(req, resp);
            }
        }

    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        int studentid = Integer.parseInt(req.getParameter("studentid"));
        String studentname = req.getParameter("studentname");
        String studentclass = req.getParameter("studentclass");
        StudentBizimpl ddi = new StudentBizimpl();
        Student student = new Student();
        student.setStudentid(studentid);
        student.setStudentname(studentname);
        student.setStudentclass(studentclass);
        boolean boo = ddi.register(student);
        if (boo) {
            resp.sendRedirect("Login.jsp");
        } else {
            resp.getWriter().println("注册失败");
        }
    }

    public void Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        int studentid = Integer.parseInt(req.getParameter("studentid"));
        String studentname = req.getParameter("studentname");
        StudentBizimpl ddi = new StudentBizimpl();
        Student student = new Student();
        student.setStudentid(studentid);
        student.setStudentname(studentname);
        boolean boo = ddi.Login(student);
        if (boo) {
            resp.getWriter().println("登陆成功");
            showall(req, resp);
        } else {
            resp.getWriter().println("登入失败");
        }

    }

    public void showall(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = new StudentBizimpl().showall();
        req.setAttribute("stu", list);
        req.getRequestDispatcher("show.jsp").forward(req, resp);

    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student stu = new Student();
        stu.setStudentid(Integer.parseInt(req.getParameter("studentid")));
        boolean del = new StudentBizimpl().delet(stu);
        if (del) {
            showall(req, resp);
        } else {
            resp.getWriter().println("删除失败");
            showall(req, resp);
        }
    }
    public void  showone(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int studentid = Integer.parseInt(request.getParameter("studentid"));
        StudentBizimpl sbi = new StudentBizimpl();
        Student student = new Student();
        student.setStudentid(studentid);
        Student student1 = sbi.showone(student);
        HttpSession session = request.getSession();
        session.setAttribute("student",student1);
        request.getRequestDispatcher("change.jsp").forward(request,response);
    }

    public void  update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int studentid = Integer.parseInt(request.getParameter("studentid"));
        String studentname = request.getParameter("studentname");
        String studentclass = request.getParameter("studentclass");
        StudentBizimpl sbi = new StudentBizimpl();
        Student student = new Student();
        student.setStudentid(studentid);
        student.setStudentname(studentname);
        student.setStudentclass(studentclass);
        boolean boo = sbi.update(student);
        if(boo){
            request.getRequestDispatcher("asd?i=2").forward(request,response);
        }else{
            request.getRequestDispatcher("change.jsp").forward(request,response);
        }
    }
        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        }

        @Override
        protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            super.service(req, resp);
        }
    }
