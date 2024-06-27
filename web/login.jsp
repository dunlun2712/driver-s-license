<%-- 
    Document   : login
    Created on : Feb 27, 2024, 11:47:02 PM
    Author     : ROG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="container">
            <h2>Đăng nhập</h2>

            <%-- Kiểm tra tham số success từ URL để hiển thị thông báo thành công --%>
            <%
                String mess = request.getParameter("mess");
                if (mess != null) {
                    if (mess.equals("you have registered")) {
            %>
            <div style="color: green;">Đăng ký thành công!</div>
            <%
                    } else if (mess.equals("wrong pass or name")) {
            %>
            <div style="color: red;">Sai tên đăng nhập hoặc mật khẩu</div>
             <%
                    } else if (mess.equals("tài khoản đã được xóa thành công!")) {
            %>
             <div style="color: green;">tài khoản đã được xóa thành công!</div>
            <%
                    } else if (mess.equals("You must login first!")) {
            %>
             <div style="color: red;">You must login first!</div>
            <%
                    } 
                }
            %>


            <form action="login" method="post">
                <label for="username">Tên đăng nhập:</label>
                <input type="text" id="name" name="name" value="${name}" required>

                <label for="password">Mật khẩu:</label>
                <input type="password" id="pass" name="pass" value="${pass}" required>

                <button type="submit">Đăng nhập</button>
            </form>

            <p>Chưa có tài khoản? <a href="register.jsp">Đăng ký ngay</a></p>
        </div>
    </body>
</html>
