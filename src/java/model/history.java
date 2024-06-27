/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ROG
 */
public class history {
    String ques,correct_ans,user_ans,id_his;

    public history(String ques, String correct_ans, String user_ans, String id_his) {
        this.ques = ques;
        this.correct_ans = correct_ans;
        this.user_ans = user_ans;
        this.id_his = id_his;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getCorrect_ans() {
        return correct_ans;
    }

    public void setCorrect_ans(String correct_ans) {
        this.correct_ans = correct_ans;
    }

    public String getUser_ans() {
        return user_ans;
    }

    public void setUser_ans(String user_ans) {
        this.user_ans = user_ans;
    }

    public String getId_his() {
        return id_his;
    }

    public void setId_his(String id_his) {
        this.id_his = id_his;
    }
    
}
