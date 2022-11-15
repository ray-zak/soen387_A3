<%--
  Created by IntelliJ IDEA.
  User: Mohit
  Date: 2022-11-12
  Time: 4:42 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Student Page </title>
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
            </ul>

        </div>
    </nav>

    <section class="Form my-4 mx-5">
        <div class="container">
            <div class="row no-gutters">
                <div class="justify-content-center col-lg-5">

                    <img src="${pageContext.request.contextPath}/img/699-6997452_administrator-network-icons-system-avatar-computer-transparent-admin.png" class="img-fluid my-4 ml-3" alt="">

                </div>

                <div class="col-lg-5 pt-3">
                    <div class="form-row">
                        <div class="col-lg-7">
                            <h1 class=" font-weight-bold text-center">Admin Template</h1>
                        </div>
                    </div>

                    <form action="<%= request.getContextPath() %>/AdminServlet" method="post">
                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="text" name="EmployementID" placeholder="EmployementID" value="${employementIDDefault}" />
                            </div>
                        </div>
                        <span style="color: red">${errorID}</span>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="text" name="FirstName" placeholder="FirstName" value="${firstNameDefault}" />
                            </div>
                        </div>
                        <span style="color: red">${errorFirstName}</span>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="text" name="LastName" placeholder="LastName" value="${lastNameDefault}" />
                            </div>
                        </div>
                        <span style="color: red">${errorLastName}</span><br/>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="date" name="DOB" placeholder="Date of Birth" value="${DOBDefault}" />
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="email" name="Email" placeholder="Email" value="${emailDefault}" />
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="text" name="Address" placeholder="Address" value="${addressDefault}" />
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="text" name="Phone" placeholder="Phone" value="${phoneDefault}" />
                            </div>
                        </div>
                        <span style="color: red">${errorPhoneNumber}</span>

                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="submit" name="registerAdmin" value="Submit" class="btn1 mt-3 mb-4" />
                            </div>
                        </div>
                        <span style="color: green">${registrationMessage}</span>
                    </form>

                </div>
            </div>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

</body>
</html>
