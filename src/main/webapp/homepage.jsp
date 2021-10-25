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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styleHomePage.css">
</head>
<body>

<header>
    <div class="container">
        <div class="profile-field">
            <span class="profile-field-users">
                <%
                    UserProject userProject = (UserProject) session.getAttribute("userProject");
                    if (userProject == null) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/userspage.jsp");
                        dispatcher.forward(request, response);
                    }
                %>
                <span class="profile-field-user-name"><%="Пользователь: " + userProject.getUserName()%></span><br>
                <span class="profile-field-user-name"><%="Идентификатор: " + userProject.getUserProjectId()%></span>

            </span>
            <form method="post" action="/ServletBy">
                <div>
                    <input class="profile-field-profile-submit" type="submit" value="Выход"/>
                </div>
            </form>
        </div>
    </div>
</header>

<div class="main">
    <div class="container">

        <div class="row">
            <div class="col-1-3"></div>
            <div class="col-2-3"></div>
        </div>

        <div class="row">
            <div class="col1-1-3">

                <form class="col1-query-in" method="post" id="checkedForm" action="/find">
                    <br/>
                    <div class="col-name">
                        ВВЕДИТЕ КРИТЕРИИ ПОИСКА:
                    </div>

                    <div class="col1-input-field">
                        <input class="col1-query-input" type="text" id="field" name="surname" placeholder="Фамилия">
                        <span class="col1-text-input">Фамилия</span>
                        <br/>
                        <input class="col1-query-input" type="text" id="field" name="name" placeholder="Имя">
                        <span class="col1-text-input">Имя</span>
                        <br/>
                        <input class="col1-query-input" type="text" id="field" name="patronymic" placeholder="Отчество">
                        <span class="col1-text-input">Отчество</span>
                        <br/>
                        <input class="col1-query-input" type="text" id="field" name="city" placeholder="Город">
                        <span class="col1-text-input">Город проживания</span>
                        <br/>
                        <input class="col1-query-input" type="text" id="field" name="car" placeholder="Марка">
                        <span class="col1-text-input">Марка автомобиля</span>
                        <br/>

                        <div>
                            <input class="col1-query-submit" type="submit" id="btnsend" value="Поиск">
                        </div>
                    </div>
                </form>


            </div>

            <div class="col2-2-3">
                <div class="col2-request-ajax">
                    <div class="col-name">
                        РЕЗУЛЬТАТ ПОИСКА ПО БАЗЕ ДАНЫХ:
                    </div>
                    <br>
                    <div class="col2-result">
                        <span class="col2-request-ajax-person">Тут будет результат первого человека</span><br>
                        <span class="col2-request-ajax-person">Тут будет результат вторго человека</span><br>
                    </div>


                </div>

            </div>


        </div>
    </div>
</div>


<footer class="container">
    <div id="myfooter"></div>
</footer>

</body>
<script type="text/javascript" src="resources/myhandler.js"></script>
</html>