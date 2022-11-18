<%--
  Created by IntelliJ IDEA.
  User: raymondzakhour
  Date: 2022-11-03
  Time: 4:37 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Student Login </title>
    <link rel="stylesheet" href=".././Styles/new_style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light ">
    <a class="navbar-brand"> <h2>Welcome To Concordia</h2></a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/A2_war_exploded/index.jsp">Home</a>
            </li>
        </ul>

    </div>
</nav>



<div class="container mt-5">

    <div class="text-center">
        <h4> Register in a course </h4>
        <p class="lead"> Please Enter your Student ID and The Semester which You'd like to Register a Course For</p>
    </div>

    <div class="row justify-content-center my-5">

        <div class="col-lg-6">
            <form method="post" action="/A2_war_exploded/ShowCourses">
                <label class="form-label"> Student ID:</label>
                <input type="number" name="StudentID" placeholder="Student ID" class="form-control" />


                <label class="form-label"> Choose a term:</label>
                <select class="form-control" name="select">
                    <option selected="selected">*</option>
                    <option name="fall" value="fall"> Fall Term </option>
                    <option name="winter" value="winter"> Winter Term </option>
                    <option name="summer" value= "summer"> Summer Term </option>
                </select>

                <br/>
                <div class="text-center">
                    <button class="btn btn-primary mb-3" type="submit">see available Courses</button>
                </div>
            </form>
        </div>
    </div>

</div>


<div class="container">

    <div class="text-center">
        <h4> Edit My Courses</h4>
        <p class="lead"> Please Enter your Student ID and The Semester which You'd like to Register a Course For</p>
    </div>

    <div class="row justify-content-center my-5">

        <div class="col-lg-6">
            <form method="post" action="/A2_war_exploded/MyCourses">
                <label class="form-label"> Student ID:</label>
                <input type="number" name="StudentID" placeholder="Student ID" class="form-control" />


                <label class="form-label"> Choose a term:</label>
                <select class="form-control" name="select">
                    <option selected="selected">*</option>
                    <option name="fall" value="fall"> Fall Term </option>
                    <option name="winter" value="winter"> Winter Term </option>
                    <option name="summer" value= "summer"> Summer Term </option>
                </select>

                <br/>
                <div class="text-center">
                    <button class="btn btn-primary mb-3" type="submit">see my Registered Courses</button>
                </div>
            </form>
        </div>
    </div>

</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>



</body>
</html>
