<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.String" %>
<%!
    String sendError(String login, String errorUser) {
        String errorMessage = "";
        if ((errorUser != null) || (login == null) || (login.equals(""))) {
            if (errorUser != null) {
                errorMessage = errorUser;
            }
        }
        return errorMessage;
    }
%>
<!DOCTYPE html>
<html>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styleLogin.css">

<head>
    <title>FIND</title>
</head>

<body>

<form class="login-form" method="POST" action="/user-search" id="checkedForm">
        <span class="flex-row logo">
            <h4>Введите имя пользователя</h4>
        </span>

    <dv class="flex-row">
        <input class="lf--input" type="text" id="username" name="login" placeholder="имя пользователя">
    </dv>
    <div class="flex-row">
        <input class="lf--input" type="password" id="password" name="pass" placeholder="пароль">
    </div>
    <div>
        <input id="ckb" type="checkbox" name="remember-me">
        <label class="lf--checkbox">запомнить меня</label>
    </div>
    <div>
        <input class="lf--submit" type="submit" value="Войти">
    </div>
</form>

<span class="error-user">
        <%
            String login = request.getParameter("login");
            String errorUser = (String) session.getAttribute("errorUser");
        %>

        <h3 style="color: #bc3220"><%= sendError(login, errorUser) %> </h3>
        </span>
</div>
</body>
</html>

