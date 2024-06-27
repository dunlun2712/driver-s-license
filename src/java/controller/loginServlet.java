/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import models.UserDao;

/**
 *
 * @author ROG
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao d = new UserDao();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String mess = request.getParameter("mess");
        
        if (d.checkAccountExistedByName(name)) {
            if (d.checkUser(name, pass)) {
                HttpSession session = request.getSession();
                session.setAttribute("login", name);
                String email = d.getEmail(name);
                String choice ="4";
                request.setAttribute("name", name);
                request.setAttribute("pass", pass);
                request.setAttribute("email", email);
                request.setAttribute("choice", choice);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("login.jsp?mess=wrong pass or name").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("login.jsp?mess=wrong pass or name").forward(request, response);
        }

    }

}
