<%--
  Created by IntelliJ IDEA.
  User: Sabrina
  Date: 07.10.2021
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="all-div">
    <hr>
    <br/>
    <button id="somebutton">press here</button>
    <hr>
    <br/>
</div>

<div class="all-div" id="resultdiv">
    <div>


        <script>


            $(document).on("click", "#somebutton", function () { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
                $.get("find", function (responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                    $("#resultdiv").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                });
            });
        </script>

        <br>
        <div class="all-div" id="result">
            <div>

                <script>
                    $.ajax({
                        url: 'http://localhost:8080/find',
                        method: 'POST',
                        data: {surname:, age: 25}
                    })
                        .done(function (text) {
                            $('#result').html(text);
                        });
                </script>

                <script type="text/javascript">

                    function findPerson() {
                        ajaxFunction();

                        // Here processRequest() is the callback function.
                        ajaxRequest.onreadystatechange = processRequest;

                        if (!target) target = document.getElementById("cityid");
                        var url = "http://localhost:8080/find?city=" + escape(target.value);

                        ajaxRequest.open("GET", url, true);
                        ajaxRequest.send(null);
                    }

                    function processRequest() {
                        if (req.readyState == 4) {
                            if (req.status == 200) {
                                var message = document.getElementById("userIdMessage");

                            }
                        }
                    }


                    function setMessageUsingDOM(message) {
                        var userMessageElement = document.getElementById("userIdMessage");
                        var messageText;

                        if (message == "false") {
                            userMessageElement.style.color = "red";
                            messageText = "Invalid User Id";
                        } else {
                            userMessageElement.style.color = "green";
                            messageText = "Valid User Id";
                        }

                        var messageBody = document.createTextNode(messageText);

                        // if the messageBody element has been created simple
                        // replace it otherwise append the new element
                        if (userMessageElement.childNodes[0]) {
                            userMessageElement.replaceChild(messageBody, userMessageElement.childNodes[0]);
                        } else {
                            userMessageElement.appendChild(messageBody);
                        }
                    }


                </script>

</body>
</html>
