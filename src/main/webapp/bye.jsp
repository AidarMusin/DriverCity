
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>BYE</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bye.css">
</head>
<body>

<form class="bye-form" method="POST" action="/userspage.jsp">
        <span class="flex-row bye-text">
            <h4><%="ДО НОВЫХ ВСТРЕЧ"%></h4>
        </span>

    <div>
        <input class="bye--submit" type="submit" value="Пока">
    </div>
</form>

</body>
</html>
