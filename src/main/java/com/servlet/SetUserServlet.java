package com.servlet;


import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/userset")
public class SetUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        User user = new User(req.getParameter("login"), req.getParameter("password"),
                req.getParameter("email"), req.getParameter("gender") );
        PrintWriter outWrite = resp.getWriter();
        outWrite.println("<h1 style=\"text-align: center;\">" + user + "</h1>");
    }
}
