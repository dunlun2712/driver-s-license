<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Trang Chính</title>

        <link rel="stylesheet" href="css/home.css">


        <style>
            .button-link {
                display: inline-block;
                padding: 10px 20px;
                font-size: 30px;
                text-decoration: none;
                color: white;
                background-color: dodgerblue;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .button-link:hover {
                background-color: deepskyblue;
            }
        </style>
    </head>
    <body> 
        <%
            String name = (String)request.getAttribute("name");
            String email = (String)request.getAttribute("email");
            String choice = (String)request.getAttribute("choice");
                
        %> 


        <header style="background-color: cadetblue">
            <h1>
                <a href="home?mod=4&name=<%= name %>&email=<%= email %>" class="button-link">Trang Chính</a>
            </h1>
        </header>


        <nav>
            <ul>
                <li><a href="home?mod=1&name=<%= name %>&email=<%= email %>">Xem Hồ Sơ</a></li>
                <li><a href="home?mod=2&name=<%= name %>&email=<%= email %>">Chọn Đề Thi</a></li>
                <li><a href="home?mod=3&name=<%= name %>&email=<%= email %>">Hướng dẫn thi thực hành</a></li>
            </ul>
        </nav>

        <form action="admin" method="get">

            <c:choose>
                <c:when test="${choice==4}">
                    <section>
                        <h1>Chào mừng bạn đến với trang web ôn thi lái xe</h1><hr>
                        <p>
                            Nơi cung cấp thông tin hữu ích và bài thi mẫu để bạn ôn tập và chuẩn bị cho kỳ thi lái xe của mình.
                        </p>

                        <h3>
                            1. Hồ sơ
                        </h3>
                        <p>

                        <li> Xóa tài khoản: cho phép người dùng xóa tất cả dữ liệu và tài khoản</li>
                        <li> Thay đổi mật khẩu: cho phép người dùng thay đổi mật khẩu mới</li>
                        <li> xem kêt quả cũ: show lịch sử bài làm và kết quả của người dùng </li>

                        </p>
                        <br>
                        <h3>
                            2. BỘ ĐỀ THI THỬ BẰNG LÁI XE MÁY A1
                        </h3>
                        <p>
                            Cấu trúc bộ đề thi sát hạch giấy phép lái xe hạng A1
                            sẽ bao gồm <a style="font-weight: bold"> 25 câu hỏi</a>,
                            mỗi câu hỏi chỉ có<a style="font-weight: bold"> duy nhất 1 đáp trả lời đúng</a>. Khác hẳn với bộ đề thi luật 
                            cũ là 2 đáp án.  

                        <li>Số lượng câu hỏi: <a style="color: red;font-weight: bold">25 Câu.</a></li>
                        <li> Yêu cầu làm đúng: <a style="color: red;font-weight: bold">21/25 Câu.</a></li>
                        <li> Thời gian: <a style="color: red;font-weight: bold">20 Phút.</a></li>
                        </p>
                        <hr>

                        <p style="font-weight: bold" >
                            <a style="color: red">VIDEO GIẢI MẸO THI A1:</a> Tham khảo video hướng dẫn giải 200 câu hỏi A1 
                            được nhà trường biên soạn theo từng phần, các bạn xem để nắm rõ nội dung
                            và cách chọn đáp án nhanh nhất.<br>
                            Xem thêm các phần mẹo thi khác theo danh sách bên dưới: 
                        <li> Luật:  <a href="https://youtu.be/FtxdcouHUj4" target="_blank" rel="noopener">Tại Đây</a></li>
                        <li> Luật & Phân Tích: <a href="https://youtu.be/zB4M2k-h6Ug" target="_blank" rel="noopener">Tại Đây</a></li>
                        <li> Phần Biển Báo:   <a href="https://youtu.be/bwzG6J6_g3c" target="_blank" rel="noopener">Tại Đây</a></li>



                        </p>
                    </section>
                </c:when>
                <c:when test="${option==2}"> 
                    <input type="hidden" name="name" value="<%= name %>">
                    <input type="hidden" name="email" value="<%= email %>">
                    <table style="text-align: center;margin: auto;font-size: 40px">
                        <tr>
                            <td >
                                <%
                                    String mess = request.getParameter("mess");
                                    if (mess != null) {
                                        if (mess.equals("Đã thay đổi mật khẩu thành công!")) {
                                %>
                                <div style="color: green;">Đã thay đổi mật khẩu thành công!</div>
                                <%
                                        } else if (mess.equals("Mật khẩu cũ chưa đúng!")) {
                                %>
                                <div style="color: red;">Mật khẩu cũ chưa đúng!</div>
                                <%
                                        } 
                                    }
                                %>
                                Name:<br> <input style="font-size: 35px" type="text" name="name" value="<%= name %>"  readonly><br>
                                Nhập mật khẩu cũ:<br>
                                <input style="font-size: 35px" type="text" name="passOld" ><br>
                                Nhập mật khẩu mới:<br>
                                <input style="font-size: 35px" type="text" name="passNew" ><br>


                            </td>
                        </tr>
                        <tr > 
                            <td style="margin: auto;text-align: center;">
                                <input type="submit" name="home" value="Home">
                                <input type="submit" name="change" value="Change">
                            </td>
                        </tr>

                    </table>
                </c:when>
                <c:when test="${choice==1}">
                    <h2>Thông Tin Người Dùng</h2>
                    Email: <%= email %><br>
                    Name: <%= name %><br>
                    <input type="hidden" name="name" value="<%= name %>">
                    <input type="hidden" name="email" value="<%= email %>">
                    <button type="submit" name="op"  value="2">thay đổi mật khẩu</button><br>
                    <button type="submit" name="op"  value="3">Xem Kết quả cũ</button><br>
                    <button type="submit" name="op"  value="4">Quản lý người dùng</button><br>
                    <button type="submit" name="exit" formaction="login.jsp">Đăng xuất</button>
                    <c:choose>

                        <c:when test="${option==3}">
                            <table>
                                <tr>
                                    <td>Name </td>
                                    <td>Email</td>
                                    <td>Result</td>
                                    <td>ExamID </td>
                                </tr>

                                <c:forEach var="u" items="${user}">
                                    <tr>
                                        <td>${u.getName()}</td>
                                        <td>${u.getEmail()}</td>
                                        <td>${u.getKetqua()}</td>
                                        <td>${u.getDe()}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:when>
                        <c:when test="${option==4}">
                            <br><!-- comment -->
                            Name:<input type="text" name="name"/>
                            <input type="submit" formaction="login.jsp" value="SEARCH" name="search"/>
                        </form>

                            <table border="1" style="text-align: center">
                            <tr>
                                <td>Name </td>
                                <td>Email</td>
                                <td>Result</td>
                                <td>ExamID </td>
                            </tr>
                            <c:forEach items="${data}" var="u">
                                <tr>

                                    <td>${u.getName()}</td>
                                    <td>${u.getEmail()}</td>
                                    <td>${u.getKetqua()}</td>
                                    <td>${u.getDe()}</td>
                                    <td><a href="admin?name=${u.getName()}">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>

                </c:choose>
            </c:when>

            <c:when test="${choice==3}">
                <%@include file="guideSaHinh.jsp" %>

            </c:when>

            <c:when test="${choice==2}">

                <input type="hidden" name="name" value="<%= name %>">
                <input type="hidden" name="email" value="<%= email %>">

                <div class="exam-selection">
                    <h2>Chọn Đề Thi Thử</h2>
                    <label for="examId">Chọn Đề Thi:</label>
                    <select name="examId" id="examId">
                        <option value="1">Đề Thi Số 1</option>
                        <option value="2">Đề Thi Số 2</option>
                        <option value="3">Đề Thi Số 3</option> 
                        <option value="4">Đề Thi Số 4</option>
                        <option value="5">Đề Thi Số 5</option>
                        <option value="6">Đề Thi Số 6</option>
                        <option value="7">Đề Thi Số 7</option>
                        <option value="8">Đề Thi Số 8</option>
                    </select>
                    <br>
                    <input type="submit" value="Bắt Đầu Thi" name="thi">
                </div>



            </c:when>


        </c:choose>
    </form>

</body>

</html>
