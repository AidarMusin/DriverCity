<%@ page import="musin.aidar.DriverCity.authorization.UserProject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="musin.aidar.DriverCity.authorization.UserProject" %>
<%@ page import="java.lang.*" %>
<!DOCTYPE html>
<html>
<head>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>FIND in DB</title>
    <style>
        .all-div {
            font-size: 16px;
            color: #293f62;
            text-align: left;
            margin-left: 60px;
            margin-top: 15px;
            margin-bottom: 20px;
        }

        .left-profile {
            font-size: 12pt;
            font-family: Verdana;
            color: #3DDB96;
            line-height: 50%;
            margin-bottom: 40px;
        }

        .input-field {
            margin-bottom: 20px;
            margin-top: 10px;
        }

        .left-profile-text {
            margin-bottom: 20px;
            font-weight: bold;
        }

        .text-input-field {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="all-div">
    <br/><br/><br/>
    <span class="left-profile">
        <%
            UserProject userProject = (UserProject) session.getAttribute("userProject");

            if (userProject == null)  {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/userspage.jsp");
                dispatcher.forward(request, response);
            } else {
                out.println("Пользователь: " + userProject.getUserName());
                out.println("Идентификатор: " + userProject.getUserProjectId());
            }
        %>
    </span>

    <form method="post" action="/ServletBy">
        <div class="left-profile">
            <button> Выход</button>
        </div>
    </form>

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
            <div class="input-field">
                <button> FIND</button>
            </div>
        </div>
    </form>

</div>

<script>
    function checkField() {
        const fileds = document.querySelectorAll('#field');
        let isNull = false;
        fileds.forEach(item => {
            if (item.value)
                isNull = true;
        })

        if (!isNull)
            alert('Заполните хотя бы одно из полей!');
    }

    const checkedForm = document.querySelector('#checkedForm');
    checkedForm.addEventListener('submit', checkField);
</script>


</body>
</html>