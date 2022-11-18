<%@ page import="soen387.a2.course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: raymondzakhour
  Date: 2022-11-16
  Time: 12:09 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Courses To Drop  </title>

    <link rel="stylesheet" href="<%= request.getContextPath() %>/Styles/new_style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script>

    coursearray=[];

    function drop_course (coursecode) {

        console.log(coursecode);
        const numofcourses = document.getElementById("numofcourses");
        numofcourses.setAttribute("value", coursearray.length+1);
    console.log(document.getElementById("courseList").childNodes);


    if(coursearray.length===5){
    alert(" You cannot add more than 5 courses");
    numofcourses.setAttribute("value", coursearray.length);
    }

    else{

    if(coursearray.length!==0){
    const deleted_submit_btn = document.getElementById("submit_btn");
    deleted_submit_btn.parentNode.removeChild(deleted_submit_btn);
    }
    coursearray.push(coursecode);
    document.getElementById("drop"+coursecode).disabled =true;
    document.getElementById("remove"+coursecode).disabled =false;

    console.log(coursearray);
    const element = document.createElement("input");
    element.setAttribute("type","text");
    element.setAttribute("id",coursecode);
    element.setAttribute('name',"course"+coursearray.length);
    element.setAttribute('value',coursecode);
    element.setAttribute('readonly', 'true');
    element.setAttribute('class','form-control')
    document.getElementById("courseList").appendChild(element);

    const submit_btn = document.createElement("input");
    submit_btn.setAttribute("type","submit");
    submit_btn.setAttribute("value","Finish Dropping");
    submit_btn.setAttribute("id","submit_btn");
    document.getElementById("courseList").appendChild(submit_btn);
    submit_btn.style.cursor = "pointer";

    }
    }

    function undo(coursecode) {
        if(coursearray.includes(coursecode)){
            if(coursearray.length===1){
                const deleted_submit_btn = document.getElementById("submit_btn");
                deleted_submit_btn.parentNode.removeChild(deleted_submit_btn);
            }
            coursearray.splice(coursearray.indexOf(coursecode),1);
            document.getElementById("numofcourses").setAttribute("value", coursearray.length);
            document.getElementById("drop"+coursecode).disabled =false;
            document.getElementById("remove"+coursecode).disabled =true;
            const deletedcourse = document.getElementById(coursecode);
            deletedcourse.parentNode.removeChild(deletedcourse);

        }
        else{
            alert("can't remove a course that it is not added");
        }
    }
</script>



</head>



<body>


<nav class="navbar navbar-expand-lg navbar-light ">
    <a class="navbar-brand"> <h2>Welcome To Concordia</h2></a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/A2_war_exploded/index.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/A2_war_exploded/Student_Pages/Student_Login.jsp">Student Page</a>
            </li>
        </ul>

    </div>
</nav>

<%
    if(session.getAttribute("verified")==null){
        response.sendRedirect("/Student_Pages/Student_Login.jsp");
    }
%>

<div class='py-3'>
    <div class='row justify-content-center'>
        <div class='col-auto'>

            <table class='table table-bordered table-secondary table-sm '>
                <tr>
                    <th> Course Code </th>
                    <th> Title </th>
                    <th> Semester </th>
                    <th> Days </th>
                    <th> Time </th>
                    <th> instructor </th>
                    <th>  Room  </th>
                    <th> Start Date </th>
                    <th> End Date </th>
                    <th> Drop Course </th>
                    <th> Undo </th>
                </tr>
                <%

                    List<course> courselst = (List<course>) request.getAttribute("registeredcourses");

                    if(courselst==null){
                %>
                <h2> You are not registered in any course fo this semester </h2>
                <%
                    }
                    else{
                        for (int i= 0;i<courselst.size();i++){
                %>

                <tr>
                    <td> <%= courselst.get(i).getCourseCode() %></td>
                    <td> <%= courselst.get(i).getTitle() %></td>
                    <td> <%= courselst.get(i).getSemester() %></td>
                    <td> <%= courselst.get(i).getDays()%></td>
                    <td> <%= courselst.get(i).getTime()%></td>
                    <td> <%= courselst.get(i).getInstructor()%></td>
                    <td> <%= courselst.get(i).getRoom() %></td>
                    <td> <%= courselst.get(i).getStartDate() %></td>
                    <td> <%= courselst.get(i).getEndDate()%></td>
                    <td> <button id="drop<%=courselst.get(i).getCourseCode()%>" onclick="drop_course('<%=courselst.get(i).getCourseCode() %>')"> Drop Course </button></td>
                    <td> <button disabled id="remove<%=courselst.get(i).getCourseCode()%>" onclick="undo('<%=courselst.get(i).getCourseCode() %>')"> Undo </button> </td>
                </tr>
                <%
                    }
                    }
                %>
            </table>

        </div>
    </div>
</div>


    <div class='row justify-content-center my-5'>
        <div class='col-lg-6'>
            <form style='display: flex; flex-flow: column nowrap' id='courseList' method='post' action='/A2_war_exploded/Drop'>
                <label class='form-label'> Student ID:
                </label>
                <input type='text'readonly value='<%= request.getAttribute("studentID")%>' id='studentid' name='studentid' class='form-control'>
                <label class='form-label'> Number of courses to drop
                </label>
                <input type='text'readonly value='0' id='numofcourses' name='numofcourses' class='form-control'>
            </form>
        </div>
    </div>






</body>
</html>
