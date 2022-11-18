<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: raymondzakhour
  Date: 2022-11-14
  Time: 11:50 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation </title>
</head>
<body>

<%
    HashMap<String,String> CoursesToEnroll = (HashMap<String, String>) request.getAttribute("CoursesToEnroll");
    HashMap<String, Boolean> droppedcourses = (HashMap<String, Boolean>) request.getAttribute("droppedcourses");

%>

    <%
    if(CoursesToEnroll!=null) {
        for(String coursecode: CoursesToEnroll.keySet() ){
    %>

    <div>
            <%
            if(CoursesToEnroll.get(coursecode).equals("registered successfully")){

            %>
            <div style=' padding: 2% ;margin: 2%;border-style: solid; border-color: darkgreen; background-color: rgba(0,255,0,0.5); font-weight: bold' >
                <h3><%= coursecode %> has been added Successfully </h3>
             </div>
        <%
            }
            else{
        %>
        <div style=' padding: 2% ;margin: 2%;border-style: solid; border-color: darkred; background-color: rgba(255,0,0,0.5); font-weight: bold' >
            <h3> Error:  <%= coursecode %></h3>
            <p> <%= CoursesToEnroll.get(coursecode)%> </p>
        </div>
        <%
        }
        %>
    </div>
<%
    }
    }
    if(droppedcourses!=null && session.getAttribute("studentid")!=null){
        for(String coursecode: droppedcourses.keySet()){

%>

<%
    if(droppedcourses.get(coursecode)){

%>
    <div style=' padding: 2% ;margin: 2%;border-style: solid; border-color: darkgreen; background-color: rgba(0,255,0,0.5); font-weight: bold' >
        <h3><%= coursecode %> has been dropped Successfully </h3>
    </div>
<%
    }
    else{
%>
<div style=' padding: 2% ;margin: 2%;border-style: solid; border-color: darkred; background-color: rgba(255,0,0,0.5); font-weight: bold' >
    <h3> Error:  <%= coursecode %></h3>
    <p> System Error. please try again </p>
</div>
<%
    }
    }
    }
%>

<a href="/A2_war_exploded/index.jsp"> Back to Home Page </a>
</body>
</html>
