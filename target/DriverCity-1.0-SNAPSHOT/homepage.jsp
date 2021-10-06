<%@ page import="musin.aidar.DriverCity.setingsPJ.UserPJ" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>FIND in DB</title>
    <style>
        p {
            font-size: 14pt;
            font-family: Verdana;
            font-weight: bold;
            color: #293f62;
            text-align: center;
            line-height: 150%;
        }
        .input-field {
            margin-left: 60px;
        }
        .text-input-field {
            font-size: 14px;
            font-weight: bold;
            color: #293f62;
            margin-left: 5px;
        }
    </style>
    <body>

        <br/>
        <br/>
        <br/>
        <span>
            <%@ page import="musin.aidar.DriverCity.setingsPJ.UserPJ" %>
            <p>
                <%
                    UserPJ userPJ = (UserPJ) session.getAttribute("user");
                    String userName = userPJ.getUserName();
                    out.println("Hello " + userName + "!");
                %>
            </p>
        </span>

        <form action="/find">
                <span>
                    <p> Please, input data </p>
                </span>
            <div class="input-field">
                <input type="text" name="surname" placeholder="Фамилия"> <span class="text-input-field">Фамилия</span>
            </div>
            <br/>
            <div class="input-field">
                <input type="text" name="name" placeholder="Имя"> <span class="text-input-field">Имя</span>
            </div>
            <br/>
            <div class="input-field">
                <input type="text" name="patronymic" placeholder="Отчество"> <span class="text-input-field">Отчество</span>
            </div>
            <br/>
            <div class="input-field">
                <input type="text" name="city" placeholder="Город"> <span class="text-input-field">Город проживания</span>
            </div>
            <br/>
            <div class="input-field">
                <input type="text" name="car" placeholder="Марка"> <span class="text-input-field">Марка автомобиля</span>
            </div>
            <br/>
            <br>
            <div class="input-field">
                <button class="login100-form-btn"> FIND </button>
            </div>
        </form>

    <%
        out.println();
    %>
    </body>
</html>