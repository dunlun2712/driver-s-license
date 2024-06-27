<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Kết Quả Thi</title>
       

        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                background-color: #f4f4f4;
            }

            #result-container {
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                width: 60%;
                padding: 20px;
                margin-top: 20px;
                text-align: center;
            }

            h2 {
                color: #333;
            }

            p {
                margin: 5px 0;
            }

            .question-container {
                background-color: #fff;
                border: 1px solid #ddd;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                width: 80%;
                margin: 20px auto;
                padding: 20px;
                text-align: left;
            }

            .question-text {
                font-weight: bold;
                font-size: 18px;
                margin-bottom: 10px;
            }

            .answer-container {
                margin-top: 10px;
            }

            .answer {
                font-size: 16px;
                margin: 5px 0;
            }

            .correct-answer {
                color: green;
            }

            .user-answer {
                color: red;
            }
        </style>

    </head>
    <body>
        <%
          String name = (String)request.getAttribute("name");
          String email = (String)request.getAttribute("email");
          String choice = (String)request.getAttribute("choice");         
        %> 

        <form action="home" method="post">
            <input type="hidden" name="name" value="<%= name %>">
            <input type="hidden" name="email" value="<%= email %>">
            <input type="hidden" name="choice" value="4">
            <div id="result-container">
                <h2>Kết Quả Thi</h2>
                <c:choose>
                    <c:when test="${not empty correctAnswers}">
                        <c:set var="rs" value="${Integer.parseInt(correctAnswers)}" />
                        <c:choose>
                            <c:when test="${rs < 21}">
                                <h1 style="color: red">Không đạt</h1>
                            </c:when>
                            <c:otherwise>
                                <h1 style="color: green">Đạt</h1>
                            </c:otherwise>
                        </c:choose>


                    </c:when>
                </c:choose>

                <p>Số Câu Trả Lời Đúng: ${correctAnswers}</p>
                <p>Tổng Số Câu Hỏi: ${totalQuestions}</p>
                <p>Tỷ Lệ Câu Trả Lời Đúng: ${percentageCorrect}%</p>
                <input type="hidden" name="correctAnswers" value="${correctAnswers}/25">
                <input type="hidden" name="totalQuestions" value="${totalQuestions}">
                <input type="hidden" name="percentageCorrect" value="${percentageCorrect}">
                <input type="hidden" name="made" value="${made}">
                <input type="submit" style="font-size:  30px" value="Trở về" >
            </div>

            <%-- Lặp qua danh sách câu hỏi --%>
            <c:forEach var="question" items="${questions}" varStatus="loop">
                <div class="question-container">
                    <p class="question-text">Câu ${loop.index + 1}: ${question.questionText}</p>
                    <c:if test="${question.imagePath ne null}">
                        <img src="${question.imagePath}" alt="Ảnh câu hỏi">
                    </c:if>
                    <div class="answer-container">
                        <div class="answer" >Đáp án đúng: ${question.getCorrectAnswer()}.
                            <c:choose>
                                <c:when test="${question.getCorrectAnswer() eq 'a'}">
                                    ${question.optionA}
                                </c:when>
                                <c:when test="${question.getCorrectAnswer() eq 'b'}">
                                    ${question.optionB}
                                </c:when>
                                <c:when test="${question.getCorrectAnswer() eq 'c'}">
                                    ${question.optionC}
                                </c:when>
                                <c:when test="${question.getCorrectAnswer() eq 'd'}">
                                    ${question.optionD}
                                </c:when>
                                <c:otherwise>
                                    Không có câu trả lời.
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="answer">Đáp án của người dùng: 
                            <c:choose>
                                <c:when test="${question.userAnswer eq question.correctAnswer}">
                                    <span class="correct-answer">${question.userAnswer}
                                        <c:choose>
                                            <c:when test="${question.userAnswer eq 'a'}">
                                                ${question.optionA}
                                            </c:when>
                                            <c:when test="${question.userAnswer eq 'b'}">
                                                ${question.optionB}
                                            </c:when>
                                            <c:when test="${question.userAnswer eq 'c'}">
                                                ${question.optionC}
                                            </c:when>
                                            <c:when test="${question.userAnswer eq 'd'}">
                                                ${question.optionD}
                                            </c:when>
                                            <c:otherwise>
                                                Không có câu trả lời.
                                            </c:otherwise>
                                        </c:choose></span>
                                    </c:when>
                                    <c:otherwise>
                                    <span class="user-answer">${question.userAnswer}
                                        <c:choose>
                                            <c:when test="${question.userAnswer eq 'a'}">
                                                ${question.optionA}
                                            </c:when>
                                            <c:when test="${question.userAnswer eq 'b'}">
                                                ${question.optionB}
                                            </c:when>
                                            <c:when test="${question.userAnswer eq 'c'}">
                                                ${question.optionC}
                                            </c:when>
                                            <c:when test="${question.userAnswer eq 'd'}">
                                                ${question.optionD}
                                            </c:when>
                                            <c:otherwise>
                                                Không có câu trả lời.
                                            </c:otherwise>
                                        </c:choose></span>
                                    </c:otherwise>
                                </c:choose>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </form>
    </body>
</html>
