<%--
  Created by IntelliJ IDEA.
  User: Mohit
  Date: 2022-11-14
  Time: 2:38 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
if(session.getAttribute("verifiedAdmin") == null){

    response.sendRedirect("/soen387_A2/Admin_Pages/Admin_Login.jsp");

}
%>
<html>
<head>
    <meta charset="UTF-8">
    <title> Course Page </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/new_style.css">
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
                    <a class="nav-link" href="../index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./Admin_Login.jsp">Admin Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./AdminPage.jsp?verified=12345">Admin Page</a>
                </li>
            </ul>

        </div>
    </nav>

    <section class="Form my-4 mx-5">
        <div class="container">
            <div class="row no-gutters">
                <div class="col-lg-5">
                    <img src="img/course-selection-high-schol-Google-Search.png" class="img-fluid mt-6 ml-5" alt="">
                </div>

                <div class="col-lg-7 px-5 pt-5">
                    <div class="form-row">
                        <div class="col-lg-7">
                            <h1 class=" font-weight-bold text-center">Course Template</h1>
                        </div>
                    </div>

                    <form action="<%= request.getContextPath() %>/AdminServlet" method="post">

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="text" name="CourseCode" class="form-control" placeholder="Course Code" value="${courseCodeDefault}" required />
                            </div>
                        </div>
                        <span style="color: red">${errorCourseCode}</span>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="text" name="Title" class="form-control" placeholder="Course Title" value="${titleDefault}" required/>
                            </div>
                        </div>
                        <span style="color: red">${errorTitle}</span>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="text" name="Semester" class="form-control" placeholder="Semester" value="${semesterDefault}" required />
                            </div>
                        </div>
                        <span style="color: red">${errorSemester}</span>
                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="text" name="days" class="form-control" placeholder="Days" value="${daysDefault}" required />
                            </div>
                        </div>
                        <span style="color: red">${errorDays}</span>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="time" name="Time" class="form-control" placeholder="Time" value="${timeDefault}" required />
                            </div>
                        </div>
                        <span style="color: red">${errorTime}</span>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="text" name="instructor" class="form-control" placeholder="Instructor" value="${instructorDefault}" required />
                            </div>
                        </div>
                        <span style="color: red">${errorInstructor}</span>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="text" name="room" class="form-control" placeholder="Room" value="${roomDefault}" required />
                            </div>
                        </div>
                        <span style="color: red">${errorRoom}</span>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="date" name="StartDate" class="form-control" placeholder="Start Date" value="${startDateDefault}" required />
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="date" name="EndDate" class="form-control" placeholder="End Date" value="${endDateDefault}" required />
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <button type="submit" name="createCourse" value="Submit" class="btn1 mt-3 mb-4">Create Course</button>
                            </div>
                        </div>

                        <span style="color: green">${courseCreationMessage}</span>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>
