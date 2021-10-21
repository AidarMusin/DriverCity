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
<!doctype html>
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss.css">


<head>
    <title>FIND</title>
</head>
<body>


<br/>
<div style="text-align: center">
    <br>
    <br>
    <form method="POST" action="/user-search" id="checkedForm">
            <span>
                <p> Please, input user name and password </p>
            </span>
        <input class="field_av" type="text" id="field_l" name="login" placeholder="userLogin">
        <br/>
        <input class="field_av" type="password" id="field_p" name="pass" placeholder="userPass">
        <br/>
        <div>
            <input id="ckb" type="checkbox" name="remember-me">
            <label> Remember me </label>
        </div>
        <div>
            <p>
                <button> Login</button>
            </p>
        </div>
    </form>

    <span class="error-user">
        <%
            String login = request.getParameter("login");
            String errorUser = (String) session.getAttribute("errorUser");
        %>

        <h3 style="color: crimson"><%= sendError(login, errorUser) %> </h3>
        </span>
</div>
</body>
</html>

