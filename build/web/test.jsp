<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết Quả Thi</title>
    <!-- Các định dạng CSS hoặc CSS styling nếu cần -->
</head>
<body>
    <h2>Danh sách kết quả</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Tên người dùng</th>
                <th>Mã đề</th>
                <th>Câu hỏi</th>
                <th>Đáp án đúng</th>
                <th>Đáp án của người làm</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="result" items="${userResults}">
                <tr>
                    <td>${result.username}</td>
                    <td>${result.examCode}</td>
                    <td>${result.questionText}</td>
                    <td>${result.correctAnswer}</td>
                    <td>${result.userAnswer}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
