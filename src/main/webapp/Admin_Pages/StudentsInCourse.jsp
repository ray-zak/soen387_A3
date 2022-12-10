<%@ page import="java.util.ArrayList"
         import="soen387.a2.CourseDAO"%><%--
  Created by IntelliJ IDEA.
  User: ram
  Date: 2022-11-17
  Time: 12:45 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  CourseDAO cd= new CourseDAO();
  String[]  courses=cd.fetchAllCourseCodes();
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title> Student Page </title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
  <link rel="stylesheet" href="<%= request.getContextPath()%>/Admin_Pages/styles/new_style.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light ">
  <a class="navbar-brand" href="#"> <h2>Welcome To Concordia</h2></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="<%= request.getContextPath()%>/Admin_Pages/AdminPage.jsp">Home</a>
      </li>
    </ul>

  </div>
</nav>

<section class="Form my-3 mx-5">
  <div class="container">
    <div class="row no-gutters p-3">
      <h1 class=" font-weight-bold text-center">Choose A Course</h1>
      <form  action="<%= request.getContextPath() %>/AdminServlet"  method="GET" >
        <div class="search_select_box">
          <select data-live-search="true" class="w-100" id="course" name="course" size="4" multiple>

            <%
              //String[] courses= (String[])session.getAttribute("courseList");
              for(int i=0; i< courses.length;i++){
                out.println("<option value="+courses[i]+">"+courses[i]+"</option>");}
            %>

          </select>

          <input value=3 type="hidden" name="formNumber" />
          <button type="submit" name="submit" value="Submit" class="btn1">Enter</button>
        </div>
      </form>
    </div>
  </div>
</section>



<div class="container ">
  <div>
    <h2 class=" font-weight-bold text-center">Courses</h2>
  </div>
  <div class="row justify-content-center p-3">
    <div class="col-lg-3">
      <div class="list-group">
        <%
          if(session.getAttribute("studentslist")!=null){
            ArrayList<Integer> studentslist= (ArrayList <Integer>)session.getAttribute("studentslist");
            if(studentslist.size() > 0){
              for(int i=0; i< studentslist.size(); i++){
                out.println("<div class= \"list-group-item py-3 \">");
                out.println("<h5 class=\"text-center mb-1 \"/>");
                out.println(studentslist.get(i));
                out.println("</h5>");
                out.println("</div>");}}
          }
        %>


      </div>
    </div>
  </div>
</div>

<div class="container mt-3">
  <div class="row justify-content-center p-3">
    <p class="text-center"><a href="<%= request.getContextPath() %>/Admin_Pages/AdminPage.jsp">Back To Admin Page</a></p>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
<script>$(document).ready(function(){
  $('.search_select_box select').selectpicker();
}) </script>
</body>
</html>