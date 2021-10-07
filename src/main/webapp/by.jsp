<%--
  Created by IntelliJ IDEA.
  User: Sabrina
  Date: 07.10.2021
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BY</title>
    <p>
    <h1 style="text-align: center">

        <%
            out.println("До новых встреч");
            Thread.sleep(2000);
            out.println("До новых встреч");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage.jsp");
            dispatcher.forward(request, response);
        %>
    </h1>
    </p>
</head>
<body>

</body>
</html>
