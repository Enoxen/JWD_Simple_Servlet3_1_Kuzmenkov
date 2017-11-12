<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input page</title>
</head>
<body>
<form action="FrontController" method="get">
    <input type="hidden" name="command" value="logination">
    <br>Enter name:
    <br><input type="text" name="name" value="">
    <br>Enter surname:
    <br><input type="text" name="surname" value="">
    <input type="submit" value="Отправить">
</form>
</body>
</html>
