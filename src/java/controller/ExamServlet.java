/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import model.Question;
import model.Users;
import models.QuestionDAO;
import models.UserDao;
// Trong servlet

@WebServlet(name = "examServlet", urlPatterns = {"/examServlet"})
public class ExamServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String passOld = request.getParameter("passOld");
        String passNew = request.getParameter("passNew");
        String de = request.getParameter("examId");
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        String maDe = "";
        QuestionDAO questionDAO = new QuestionDAO();
        List<Question> questions = null;
        UserDao u = new UserDao();
        String choice = "";
        String option = "";
        String op = request.getParameter("op");

        if (request.getParameter("home") != null) {

            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        if (request.getParameter("change") != null) {
            option = "2";
            if (u.checkUser(name, passOld)) {
                u.deleteUser(name);
                String mess= "update";
                request.setAttribute("mess", mess);
                u.addUser(name, passNew, email);
                
                request.setAttribute("pass", passNew);
                request.setAttribute("option", option);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("option", option);
                request.getRequestDispatcher("home.jsp?mess=Mật khẩu cũ chưa đúng!").forward(request, response);
            }
        }
        if (de != null) {
            switch (de) {
                case "1":
                    questions = questionDAO.getDe1();
                    questions = questionDAO.getResultForDisplay();
                    maDe = "1";
                    break;
                case "2":
                    questions = questionDAO.getDe2();
                    questions = questionDAO.getResultForDisplay();
                    maDe = "2";
                    break;
                case "3":
                    questions = questionDAO.getDe3();
                    questions = questionDAO.getResultForDisplay();
                    maDe = "3";
                    break;
                case "4":
                    questions = questionDAO.getDe4();
                    questions = questionDAO.getResultForDisplay();
                    maDe = "4";
                    break;
                case "5":
                    questions = questionDAO.getDe5();
                    questions = questionDAO.getResultForDisplay();
                    maDe = "5";
                    break;
                case "6":
                    questions = questionDAO.getDe6();
                    questions = questionDAO.getResultForDisplay();
                    maDe = "6";
                    break;
                case "7":
                    questions = questionDAO.getDe7();
                    questions = questionDAO.getResultForDisplay();
                    maDe = "7";
                    break;
                case "8":
                    questions = questionDAO.getDe8();
                    questions = questionDAO.getResultForDisplay();
                    maDe = "8";
                    break;
            }
        }
        if (op != null) {
            switch (op) {
                case "1":
                    u.deleteUser(name);
                    u.deteteResult(name);
                    request.getRequestDispatcher("login.jsp?mess=tài khoản đã được xóa thành công!").forward(request, response);
                    break;
                case "2":
                    choice = "1";
                    option = "2";

                    request.setAttribute("option", option);
                    request.setAttribute("choice", choice);
                    request.getRequestDispatcher("home.jsp").forward(request, response);

                    break;
                case "3":
                    choice = "1";
                    option = "3";

                    ArrayList<Users> user = u.getResultByName(name);
                    questions = questionDAO.getHistory();
                    
                    request.setAttribute("questions", questions);
                    request.setAttribute("user", user);
                    request.setAttribute("option", option);
                    request.setAttribute("choice", choice);
                    request.getRequestDispatcher("viewSubmission.jsp").forward(request, response);
                    break;
                case "4":
                    choice = "1";
                    option = "4";
                    
                    request.setAttribute("option", option);
                    request.setAttribute("choice", choice);
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                    break;

            }
        }

        request.setAttribute("questions", questions);
        request.setAttribute("maDe", maDe);
        request.getRequestDispatcher("displayExam.jsp").forward(request, response);
    }
}
