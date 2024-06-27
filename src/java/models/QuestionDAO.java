package models;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Question;

public class QuestionDAO extends DBContext {

    public QuestionDAO() {

    }

    Connection cnn;// Kết nối DB
    PreparedStatement stm; // Thực hiện các câu lệnh sql
    ResultSet rs; // lưu kết quả truy vấn

    private void connectDB() {
        cnn = connection;
        if (cnn != null) {
            System.out.println("Connect success");
        } else {
            System.out.println("Not success");
        }
    }

    public List<Question> getDe1() {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "INSERT INTO thi (question_text, option_a, option_b, option_c, option_d, correct_answer, image_path)\n"
                    + "SELECT TOP 25 question_text, option_a, option_b, option_c, option_d, correct_answer, image_path\n"
                    + "FROM de1\n"
                    + "ORDER BY NEWID();";
            PreparedStatement stm = connection.prepareStatement(strSQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setQuestionId(rs.getString("ques_id"));
                ques.setQuestionText(rs.getString("question_text"));
                ques.setOptionA(rs.getString("option_a"));
                ques.setOptionB(rs.getString("option_b"));
                ques.setOptionC(rs.getString("option_c"));
                ques.setOptionD(rs.getString("option_d"));
                ques.setCorrectAnswer(rs.getString("correct_answer"));
                ques.setImagePath(rs.getString("image_path"));
                questions.add(ques);

            }
        } catch (Exception e) {
            System.out.println("getAllQuestions: " + e.getMessage());
        }
        return questions;
    }

    public List<Question> getDe2() {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "INSERT INTO thi (question_text, option_a, option_b, option_c, option_d, correct_answer, image_path)\n"
                    + "SELECT TOP 25 question_text, option_a, option_b, option_c, option_d, correct_answer, image_path\n"
                    + "FROM de2\n"
                    + "ORDER BY NEWID();";
            PreparedStatement stm = connection.prepareStatement(strSQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setQuestionId(rs.getString("ques_id"));
                ques.setQuestionText(rs.getString("question_text"));
                ques.setOptionA(rs.getString("option_a"));
                ques.setOptionB(rs.getString("option_b"));
                ques.setOptionC(rs.getString("option_c"));
                ques.setOptionD(rs.getString("option_d"));
                ques.setCorrectAnswer(rs.getString("correct_answer"));
                ques.setImagePath(rs.getString("image_path"));
                questions.add(ques);
            }
        } catch (Exception e) {
            System.out.println("getAllQuestions: " + e.getMessage());
        }
        return questions;
    }

    public List<Question> getDe3() {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "INSERT INTO thi (question_text, option_a, option_b, option_c, option_d, correct_answer, image_path)\n"
                    + "SELECT TOP 25 question_text, option_a, option_b, option_c, option_d, correct_answer, image_path\n"
                    + "FROM de3\n"
                    + "ORDER BY NEWID();";
            PreparedStatement stm = connection.prepareStatement(strSQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setQuestionId(rs.getString("ques_id"));
                ques.setQuestionText(rs.getString("question_text"));
                ques.setOptionA(rs.getString("option_a"));
                ques.setOptionB(rs.getString("option_b"));
                ques.setOptionC(rs.getString("option_c"));
                ques.setOptionD(rs.getString("option_d"));
                ques.setCorrectAnswer(rs.getString("correct_answer"));
                ques.setImagePath(rs.getString("image_path"));
                questions.add(ques);
            }
        } catch (Exception e) {
            System.out.println("getAllQuestions: " + e.getMessage());
        }
        return questions;
    }

    public List<Question> getDe4() {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "INSERT INTO thi (question_text, option_a, option_b, option_c, option_d, correct_answer, image_path)\n"
                    + "SELECT TOP 25 question_text, option_a, option_b, option_c, option_d, correct_answer, image_path\n"
                    + "FROM de4\n"
                    + "ORDER BY NEWID();";
            PreparedStatement stm = connection.prepareStatement(strSQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setQuestionId(rs.getString("ques_id"));
                ques.setQuestionText(rs.getString("question_text"));
                ques.setOptionA(rs.getString("option_a"));
                ques.setOptionB(rs.getString("option_b"));
                ques.setOptionC(rs.getString("option_c"));
                ques.setOptionD(rs.getString("option_d"));
                ques.setCorrectAnswer(rs.getString("correct_answer"));
                ques.setImagePath(rs.getString("image_path"));
                questions.add(ques);
            }
        } catch (Exception e) {
            System.out.println("getAllQuestions: " + e.getMessage());
        }
        return questions;
    }

    public List<Question> getDe5() {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "INSERT INTO thi (question_text, option_a, option_b, option_c, option_d, correct_answer, image_path)\n"
                    + "SELECT TOP 25 question_text, option_a, option_b, option_c, option_d, correct_answer, image_path\n"
                    + "FROM de5\n"
                    + "ORDER BY NEWID();";
            PreparedStatement stm = connection.prepareStatement(strSQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setQuestionId(rs.getString("ques_id"));
                ques.setQuestionText(rs.getString("question_text"));
                ques.setOptionA(rs.getString("option_a"));
                ques.setOptionB(rs.getString("option_b"));
                ques.setOptionC(rs.getString("option_c"));
                ques.setOptionD(rs.getString("option_d"));
                ques.setCorrectAnswer(rs.getString("correct_answer"));
                ques.setImagePath(rs.getString("image_path"));
                questions.add(ques);
            }
        } catch (Exception e) {
            System.out.println("getAllQuestions: " + e.getMessage());
        }
        return questions;
    }

    public List<Question> getDe6() {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "INSERT INTO thi (question_text, option_a, option_b, option_c, option_d, correct_answer, image_path)\n"
                    + "SELECT TOP 25 question_text, option_a, option_b, option_c, option_d, correct_answer, image_path\n"
                    + "FROM de6\n"
                    + "ORDER BY NEWID();";
            PreparedStatement stm = connection.prepareStatement(strSQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setQuestionId(rs.getString("ques_id"));
                ques.setQuestionText(rs.getString("question_text"));
                ques.setOptionA(rs.getString("option_a"));
                ques.setOptionB(rs.getString("option_b"));
                ques.setOptionC(rs.getString("option_c"));
                ques.setOptionD(rs.getString("option_d"));
                ques.setCorrectAnswer(rs.getString("correct_answer"));
                ques.setImagePath(rs.getString("image_path"));
                questions.add(ques);
            }
        } catch (Exception e) {
            System.out.println("getAllQuestions: " + e.getMessage());
        }
        return questions;
    }

    public List<Question> getDe7() {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "INSERT INTO thi (question_text, option_a, option_b, option_c, option_d, correct_answer, image_path)\n"
                    + "SELECT TOP 25 question_text, option_a, option_b, option_c, option_d, correct_answer, image_path\n"
                    + "FROM de7\n"
                    + "ORDER BY NEWID();";
            PreparedStatement stm = connection.prepareStatement(strSQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setQuestionId(rs.getString("ques_id"));
                ques.setQuestionText(rs.getString("question_text"));
                ques.setOptionA(rs.getString("option_a"));
                ques.setOptionB(rs.getString("option_b"));
                ques.setOptionC(rs.getString("option_c"));
                ques.setOptionD(rs.getString("option_d"));
                ques.setCorrectAnswer(rs.getString("correct_answer"));
                ques.setImagePath(rs.getString("image_path"));
                questions.add(ques);
            }
        } catch (Exception e) {
            System.out.println("getAllQuestions: " + e.getMessage());
        }
        return questions;
    }

    public List<Question> getDe8() {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "INSERT INTO thi (question_text, option_a, option_b, option_c, option_d, correct_answer, image_path)\n"
                    + "SELECT TOP 25 question_text, option_a, option_b, option_c, option_d, correct_answer, image_path\n"
                    + "FROM de8\n"
                    + "ORDER BY NEWID();";
            PreparedStatement stm = connection.prepareStatement(strSQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setQuestionId(rs.getString("ques_id"));
                ques.setQuestionText(rs.getString("question_text"));
                ques.setOptionA(rs.getString("option_a"));
                ques.setOptionB(rs.getString("option_b"));
                ques.setOptionC(rs.getString("option_c"));
                ques.setOptionD(rs.getString("option_d"));
                ques.setCorrectAnswer(rs.getString("correct_answer"));
                ques.setImagePath(rs.getString("image_path"));
                questions.add(ques);
            }
        } catch (Exception e) {
            System.out.println("getAllQuestions: " + e.getMessage());
        }
        return questions;
    }

    public List<Question> getResultForDisplay() {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "select top 25 * from thi order by ques_id desc";
            PreparedStatement stm = connection.prepareStatement(strSQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setQuestionId(rs.getString("ques_id"));
                ques.setQuestionText(rs.getString("question_text"));
                ques.setOptionA(rs.getString("option_a"));
                ques.setOptionB(rs.getString("option_b"));
                ques.setOptionC(rs.getString("option_c"));
                ques.setOptionD(rs.getString("option_d"));
                ques.setCorrectAnswer(rs.getString("correct_answer"));
                ques.setImagePath(rs.getString("image_path"));
                questions.add(ques);
            }
        } catch (Exception e) {
            System.out.println("getAllQuestions: " + e.getMessage());
        }
        return questions;
    }

    public List<Question> getOriginla1() {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "selet * from de1";
            PreparedStatement stm = connection.prepareStatement(strSQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setQuestionId(rs.getString("ques_id"));
                ques.setQuestionText(rs.getString("question_text"));
                ques.setOptionA(rs.getString("option_a"));
                ques.setOptionB(rs.getString("option_b"));
                ques.setOptionC(rs.getString("option_c"));
                ques.setOptionD(rs.getString("option_d"));
                ques.setCorrectAnswer(rs.getString("correct_answer"));
                ques.setImagePath(rs.getString("image_path"));
                questions.add(ques);
            }
        } catch (Exception e) {
            System.out.println("getAllQuestions: " + e.getMessage());
        }
        return questions;
    }

    public void insertIntoHistory(String questionText,String a,String b,String c,String d, String correctAnswer, String userAnswer,String image, String idhis) {
        String sql = "INSERT INTO history  VALUES (?, ?,?,?,?,?, ?,?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, questionText);
            stm.setString(2, a);
            stm.setString(3, b);
            stm.setString(4, c);
            stm.setString(5, d);
            stm.setString(6, correctAnswer);
            stm.setString(7, userAnswer);
            stm.setString(8, image);
            stm.setString(9, idhis);
            stm.executeUpdate(); // Sử dụng executeUpdate() thay vì execute() để thực hiện câu lệnh INSERT
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
    }

    public int getidhis() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
     public List<Question> getHistory() {
        List<Question> questions = new ArrayList<>();
        try {
            String strSQL = "select top 25 * from history order by ques_id desc";
            PreparedStatement stm = connection.prepareStatement(strSQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setQuestionId(rs.getString("ques_id"));
                ques.setQuestionText(rs.getString("ques_text"));
                 ques.setOptionA(rs.getString("option_a"));
                ques.setOptionB(rs.getString("option_b"));
                ques.setOptionC(rs.getString("option_c"));
                ques.setOptionD(rs.getString("option_d"));
                ques.setCorrectAnswer(rs.getString("correct_ans"));
                ques.setUserAnswer(rs.getString("user_ans"));
                ques.setImagePath(rs.getString("image_path"));
                
                questions.add(ques);
            }
        } catch (Exception e) {
            System.out.println("getAllQuestions: " + e.getMessage());
        }
        return questions;
    }
}
