<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="musin.aidar.DriverCity.setingsPJ.Person" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Результат запроса</title>
</head>
<body>
<div>

    <%
        ArrayList<Person> personArrayList = (ArrayList<Person>) session.getAttribute("personList");

        for (Person person :personArrayList ) {
            out.println("<h3> " + person.getCity() + person.getSurname() + " " + person.getName() + " " + person.getPatronymic()
                    + " - " + person.getCity() + " - " + person.getValueCars() + " </h3>");
        }
    %>

</div>



</body>
</html>
