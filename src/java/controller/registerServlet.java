/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;
import models.UserDao;

/**
 *
 * @author ROG
 */
@WebServlet(name = "registerServlet", urlPatterns = {"/register"})
public class registerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        UserDao d = new UserDao();
        if (d.checkAccountExistedByName(name)) {
            request.getRequestDispatcher("register.jsp?mess=This name is already have").forward(request, response);

        }
        if (d.checkAccountExistedByEmail(email)) {

            request.getRequestDispatcher("register.jsp?mess=This email is already have").forward(request, response);
        } else {
            d.addUser(name, pass, email);
            request.setAttribute("name", name);
            request.setAttribute("pass", pass);
            request.getRequestDispatcher("login.jsp?mess=you have registered").forward(request, response);
        }

    }

}
