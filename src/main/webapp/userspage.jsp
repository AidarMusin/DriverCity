<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.String" %>

<!doctype html>
<html>
<link rel="stylesheet" type="text/css" href="resources/mycss.css">
<head>
    <title>FIND</title>
</head>
<body>
<%@ page import="musin.aidar.DriverCity.myObject.UserProject" %>

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
                if ((errorUser != null) || (login == null) || (login.equals(""))) {
                    if (errorUser != null) {
                        out.println(errorUser); // changed
                    }
                }
            %>
        </span>
</div>
</body>

</html>

