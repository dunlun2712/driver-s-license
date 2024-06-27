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
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;

import java.util.List;
import model.Question;

import model.UserResult;
import models.QuestionDAO;

import models.UserDao;

/**
 *
 * @author ROG
 */
@WebServlet(name = "homeServlet", urlPatterns = {"/home"})
public class homeServlet extends HttpServlet {

    List<UserResult> userResults = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mod = request.getParameter("mod");
        UserDao d = new UserDao();
        String name = request.getParameter("name");
        String email = d.getEmail(name);
        HttpSession sess = request.getSession();
        if (sess.getAttribute("login") == null) {
            request.getRequestDispatcher("login.jsp?mess=You must login first!").forward(request, response);
        }
        request.setAttribute("email", email);
        request.setAttribute("name", name);

        if (mod != null) {

            if (mod.equals("1")) {
                String choice = "1";
                QuestionDAO q = new QuestionDAO();
                List<Question> questions = q.getResultForDisplay();
                request.setAttribute("choice", choice);
                request.setAttribute("email", email);
                request.setAttribute("name", name);
                request.setAttribute("questions", questions);
                request.getRequestDispatcher("home.jsp?mod=1").forward(request, response);
            } else if (mod.equals("2")) {
                String choice = "2";

                request.setAttribute("email", email);
                request.setAttribute("name", name);
                request.setAttribute("choice", choice);

                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else if (mod.equals("3")) {
                String choice = "3";

                request.setAttribute("email", email);
                request.setAttribute("name", name);
                request.setAttribute("choice", choice);

                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else if (mod.equals("4")) {
                String choice = "4";

                request.setAttribute("email", email);
                request.setAttribute("name", name);
                request.setAttribute("choice", choice);

                request.getRequestDispatcher("home.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("email", email);
            request.setAttribute("name", name);

            request.getRequestDispatcher("home.jsp").forward(request, response);
        }

    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String made = request.getParameter("made");
        String correctAnswers = request.getParameter("correctAnswers");
        HttpSession sess = request.getSession();
        
        

        
        QuestionDAO q = new QuestionDAO();
       
        UserDao d = new UserDao();
        d.insertRS(name, correctAnswers, made);
        String choice = "4";
        request.setAttribute("choice", choice);
        request.setAttribute("email", email);
        request.setAttribute("name", name);

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
