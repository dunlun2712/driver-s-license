<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Đề Thi ${maDe}</title>
        <script type="text/javascript">
            function disableBackButton() {
                window.history.forward();
            }

            setTimeout("disableBackButton()", 0);

            window.onunload = function () {
                null;
            };
        </script>

        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                height: 100vh;
                background-color: #f4f4f4;
            }
            #header {
                text-align: center;
                font-size: 30px;
                margin-bottom: 20px;
            }
            #content {
                display: flex;
                justify-content: space-between;
                align-items: flex-start;
                width: 80%;
                margin: 0 auto;
            }
            #question-list {
                display: grid;
                grid-template-columns: repeat(5, 1fr);
                grid-gap: 10px;
            }
            #question-container {
                border: 1px solid #ddd;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                width: 75%;
                background-color: #fff;
                padding: 20px;
                display: grid;
                gap: 20px;

            }
            .question {

                font-size: 20px;
            }
            img {
                max-width: 100%;
                height: auto;
                margin-top: 10px;
            }
            .options {
                display: flex;
                flex-direction: column;
            }
            .option {
                margin-bottom: 10px;
                font-size: 20px;
            }
            #result {
                font-weight: bold;
                margin-top: 20px;
            }
            #atd {
                text-align: center;
                padding: 10px;
                width: 25%; /* Chia bảng thành 4 cột */
            }
            button {
                font-size: 18px;
                padding: 10px;
                width: 100%;
            }
        </style>
    </head>
    <body>


        <form id="examForm" action="submitExam" method="post">
            <%
    String name = (String)request.getAttribute("name");
    String email = (String)request.getAttribute("email");
    String choice = (String)request.getAttribute("choice");
                
            %> 
            <input type="hidden" name="name" value="<%= name %>">
            <input type="hidden" name="email" value="<%= email %>">

            <div id="header">
                <h2>Đề Thi ${maDe}</h2>
                <div id="timerDisplay" style="font-size: 30px; text-align: center;"></div>
            </div>

            <div id="content">
                <div id="question-list">
                    <%int i =1; %>
 <%int j =1; %>
                    <c:forEach var="question" items="${questions}" varStatus="loop">

                        <button type="button" onclick="showQuestion(${question.questionId})">Câu <%=i%></button>
                        <%i++;%>
                    </c:forEach>
                </div>

                <div id="question-container">
                    <c:forEach var="question" items="${questions}" varStatus="loop">
                        <div class="question" id="question${question.questionId}" style="display: none;">
                            <p style="font-weight: bold ">Câu <%=j%> : ${question.questionText}</p>
                            <%j ++;%>
                            <div class="options">
                                <label class="option">
                                    <input type="radio" name="q${loop.index}" value="a"> A. ${question.optionA}
                                </label>
                                <label class="option">
                                    <input type="radio" name="q${loop.index}" value="b"> B. ${question.optionB}
                                </label>

                                <c:if test="${not empty question.optionC}">
                                    <label class="option">
                                        <input type="radio" name="q${loop.index}" value="c"> C. ${question.optionC}
                                    </label>
                                </c:if>

                                <c:if test="${not empty question.optionD}">
                                    <label class="option">
                                        <input type="radio" name="q${loop.index}" value="d"> D. ${question.optionD}
                                    </label>
                                </c:if>
                            </div>
                            <input type="hidden" name="correctAnswer${loop.index}" value="${question.correctAnswer}">
                            <!-- Check if the image path is not null -->
                            <c:if test="${question.imagePath ne null}">
                                <img src="${question.imagePath}" alt="Ảnh câu hỏi">
                            </c:if>
                        </div>
                    </c:forEach>


                </div>
            </div>
            <input type="hidden" name="maDe" value="${maDe}">
            <button type="submit" style="font-size: 40px; margin-top: 50px; color: black; background-color: greenyellow" name="maDe" value="${maDe}">Submit Answers</button>
            <input type="hidden" name="totalQuestions" value="${totalQuestions}">

            <c:forEach var="question" items="${questions}" varStatus="loop">
                <input type="hidden" name="questionId${loop.index}" value="${question.questionId}">
                <input type="hidden" name="userAnswer${loop.index}" value="${request.getParameter('q' + loop.index)}">
            </c:forEach>
        </form>

        <script>
            var countdown = 1200; // 20 phút = 1200 giây
            var timerDisplay = document.getElementById("timerDisplay");

            function updateTimer() {
                var minutes = Math.floor(countdown / 60);
                var seconds = countdown % 60;
                timerDisplay.innerHTML = "Thời gian còn lại: " + minutes + " phút " + seconds + " giây";
            }

            function submitExam() {
                document.getElementById("examForm").elements["maDe"].value = "${maDe}";
                document.getElementById("examForm").submit();
            }

            setInterval(function () {
                if (countdown > 0) {
                    countdown--;
                    updateTimer();
                } else {
                    submitExam();
                }
            }, 1000);
        </script>

        <script>
            function showQuestion(questionId) {
                var questionContainers = document.querySelectorAll('.question');

                questionContainers.forEach(function (container) {
                    container.style.display = 'none';
                });

                var selectedQuestionContainer = document.getElementById('question' + questionId);
                if (selectedQuestionContainer) {
                    selectedQuestionContainer.style.display = 'block';
                }
            }
            function showQuestion(questionId) {
                var questionContainers = document.querySelectorAll('.question');

                questionContainers.forEach(function (container) {
                    container.style.display = 'none';
                });

                var selectedQuestionContainer = document.getElementById('question' + questionId);
                if (selectedQuestionContainer) {
                    selectedQuestionContainer.style.display = 'block';
                }
            }

// Thêm hàm để hiển thị câu hỏi theo thứ tự từ 1 đến 25
            function showQuestionByIndex(index) {
                var questionContainers = document.querySelectorAll('.question');

                questionContainers.forEach(function (container, i) {
                    if (i === index) {
                        container.style.display = 'block';
                    } else {
                        container.style.display = 'none';
                    }
                });
            }
        </script>

    </body>
</html>
