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
import models.QuestionDAO;

/**
 *
 * @author ROG
 */
@WebServlet(name = "submitExam", urlPatterns = {"/submitExam"})

public class submitExam extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy danh sách câu hỏi từ request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String maDe = request.getParameter("maDe");
        QuestionDAO d = new QuestionDAO();
        List<Question> questions = null;

        questions = d.getResultForDisplay();

        int totalQuestions = questions.size();
        int correctAnswers = 0;

        for (int i = 0; i < totalQuestions; i++) {
            String userAnswer = request.getParameter("q" + i);
            String correctAnswer = request.getParameter("correctAnswer" + i);

            // Kiểm tra xem câu trả lời của người dùng có khớp với câu trả lời đúng hay không
            if (userAnswer != null && userAnswer.equals(correctAnswer)) {
                correctAnswers++;
            }
            questions.get(i).setUserAnswer(userAnswer);
            d.insertIntoHistory(questions.get(i).getQuestionText(),questions.get(i).getOptionA(),questions.get(i).getOptionB(),questions.get(i).getOptionC(),questions.get(i).getOptionD(),questions.get(i).getCorrectAnswer() , questions.get(i).getUserAnswer(), questions.get(i).getImagePath() , "1");
            
        }

        // Tính phần trăm câu trả lời đúng
        int percentageCorrect = (int) ((correctAnswers / (double) totalQuestions) * 100);

        // Lưu kết quả trong thuộc tính yêu cầu
        request.setAttribute("made", maDe);
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("correctAnswers", correctAnswers);
        request.setAttribute("totalQuestions", totalQuestions);
        request.setAttribute("percentageCorrect", percentageCorrect);
        request.setAttribute("questions", questions);

        // Chuyển hướng yêu cầu đến trang result.jsp để hiển thị kết quả
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

}
