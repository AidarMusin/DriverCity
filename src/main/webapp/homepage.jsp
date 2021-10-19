<%@ page import="musin.aidar.DriverCity.myObject.UserProject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="musin.aidar.DriverCity.myObject.UserProject" %>
<%@ page import="java.lang.*" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script src="ajax.js"></script>

    <title>FIND in DB</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mycss.css">
</head>
<body>
<div class="all-div">
    <br/><br/><br/>
    <span class="left-profile">
        <%
            UserProject userProject = (UserProject) session.getAttribute("userProject");

            if (userProject == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/userspage.jsp");
                dispatcher.forward(request, response);
            } %>
        <p><%="Пользователь: " + userProject.getUserName()%></p>
        <p><%="Идентификатор: " + userProject.getUserProjectId()%></p>

    </span>

    <form method="post" action="/ServletBy">
        <div class="left-profile">
            <button> Выход</button>
        </div>
    </form>
    <br>
    <form method="post" id="checkedForm" action="/find">
        <span class="left-profile-text"> Введите критерии поиска: </span> <br/><br/>
        <div class="input-field">
            <div class="input-field"><input type="text" id="field" name="surname" placeholder="Фамилия"> <span
                    class="text-input-field">Фамилия</span><br/></div>
            <div class="input-field"><input type="text" id="field" name="name" placeholder="Имя"> <span
                    class="text-input-field">Имя</span><br/></div>
            <div class="input-field"><input type="text" id="field" name="patronymic" placeholder="Отчество"> <span
                    class="text-input-field">Отчество</span><br/></div>
            <div class="input-field"><input type="text" id="field" name="city" placeholder="Город"> <span
                    class="text-input-field">Город проживания</span><br/></div>
            <div class="input-field"><input type="text" id="field" name="car" placeholder="Марка"> <span
                    class="text-input-field">Марка автомобиля</span><br/></div>
            <div class="input-field" >
                <button id="btnsend"> FIND</button>
            </div>
        </div>
    </form>

</div>


<div id="result_form"> </div>

<script type="text/javascript" src="resources/myhandler.js"> </script>

</body>
</html>