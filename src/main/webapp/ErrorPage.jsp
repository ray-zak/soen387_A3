<%--
  Created by IntelliJ IDEA.
  User: raymondzakhour
  Date: 2022-11-11
  Time: 1:43 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page </title>
</head>
<body>
<h2> Error </h2>
<%= request.getAttribute("ErrorMessage") %>
</body>
</html>
