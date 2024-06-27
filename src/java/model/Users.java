/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ROG
 */
public class Users {
    String name,pass,email,ketqua,de;

    public Users() {
    }

    public Users(String name, String pass, String email, String ketqua, String de) {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.ketqua = ketqua;
        this.de = de;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

}
