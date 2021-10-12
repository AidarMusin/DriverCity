<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.String" %>

<!doctype html>
<html>
<style>
    p {
        font-size: 14pt;
        font-family: Verdana;
        font-weight: bold;
        color: #293f62;;
        text-align: center;
        line-height: 150%;
    }

    .error-user {
        font-size: 12pt;
        font-family: Verdana;
        font-weight: bold;
        color: #F96846;;
        text-align: center;
        line-height: 150%;
    }

    .field_av {
        margin: 5px 5px 5px 5px;
    }
</style>
<head>
    <title>FIND</title>
</head>
<body>
<%@ page import="musin.aidar.DriverCity.authorization.UserProject" %>
<%--<%--%>
<%--    UserProject userProject = (UserProject) session.getAttribute("userProject");--%>
<%--    if (userProject != null) {--%>
<%--        RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage.jsp");--%>
<%--        dispatcher.forward(request, response);--%>
<%--    }--%>
<%--%>--%>

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
                    if (errorUser != null)
                        out.println(errorUser);
                }
            %>
        </span>
</div>
</body>

</html>

