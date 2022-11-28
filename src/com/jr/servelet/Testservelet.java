package com.jr.servelet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public void  register(HttpServletRequest req, HttpServletResponse resp){

    }
    public void  Login(HttpServletRequest req, HttpServletResponse resp){

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
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
