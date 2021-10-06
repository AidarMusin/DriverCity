<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="musin.aidar.DriverCity.connetDB.SearchUserInDB" %>
<%@ page import="musin.aidar.DriverCity.setingsPJ.UserPJ" %>
<%@ page import="java.io.PrintWriter" %>
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
</style>
<head>
    <title>FIND</title>
</head>

    <body>
    <%@ page import="javax.servlet.RequestDispatcher" %>

    <%

    %>
        <br/>
        <div style="text-align: center">
            <br>
            <br>
            <form method="POST" action="/user-search">
                <span>
                    <p> Please, input user name and password </p>
                </span>
                <div>
                    <input type="text" name="login" placeholder="userLogin">
                </div>
                <br/>
                <div >
                    <input type="password" name="pass" placeholder="userPass">
                </div>
                <br/>
                <div>
                    <div>
                        <input id="ckb" type="checkbox" name="remember-me">
                        <label> Remember me </label>
                    </div>
                </div>
                <div>
                    <p><button> Login </button></p>
                </div>
            </form>
            <span class="error-user">
                <%
                    String login = request.getParameter("login");
                    if (!(login == null) && !(login.equals(""))) {
                        out.println(login + " - invalid username and password, please try again");
                    }
                %>
                <script>
                    function reset(){
                        document.getElementById('login').value="";
                    }
                </script>
            </span>
        </div>
    </body>

</html>

