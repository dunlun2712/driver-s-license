<%-- 
    Document   : register
    Created on : 25 Feb 2024, 22:11:20
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng ký</title>
        <link rel="stylesheet" href="css/style.css">

    </head>

    <body>
        <div class="container">
            <h2>Đăng ký</h2>

            <%-- Kiểm tra tham số error từ URL để hiển thị thông báo lỗi --%>
            <%
                String mess = request.getParameter("mess");
                if (mess != null) {
                    if (mess.equals("This email is already have")) {
            %>
            <div style="color: red;">Đã tồn tại email!</div>
            <%
                    } else if (mess.equals("This name is already have")) {
            %>
            <div style="color: red;">Đã có người dùng sử dụng tên này</div>

            <%
                    } 
                }
            %>


            <form action="register" method="post">
                <label for="username">Tên đăng nhập:</label>
                <input type="text"  name="name" required>

                <label for="password">Mật khẩu:</label>
                <input type="password" name="pass" required>

                <label for="email">Email:</label>
                <input type="email"  name="email" required>

                <button type="submit">Đăng ký</button>
            </form>
        </div>
    </body>
</html>
