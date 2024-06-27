package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ROG
 */

    public class UserResult {
    private String username;
    private String examCode;
    private String questionText;
    private String correctAnswer;
    private String userAnswer;

    // Constructor, getters, and setters

    public UserResult() {
    }

    public UserResult(String username, String examCode, String questionText, String correctAnswer, String userAnswer) {
        this.username = username;
        this.examCode = examCode;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
    
}
