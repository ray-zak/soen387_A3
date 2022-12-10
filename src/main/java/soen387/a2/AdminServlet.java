package soen387.a2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Locale;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {

    private AdminDOA adminDOA;

    public void init() {
        adminDOA = new AdminDOA();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int formNumber = Integer.parseInt(request.getParameter("formNumber"));

        if(formNumber==1) {
            StudentDAO sd= new StudentDAO();
            Integer[] v =  sd.fetchAllStudentIDS() ;
            System.out.println(v[0]);
            HttpSession session = request.getSession();

            session.setAttribute("studentList", v);
            if(session.getAttribute("courses")!=null){
                session.removeAttribute("courses");}
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/Admin_Pages/CourseTakenByStudent.jsp");
            rd.forward(request, response);
        }
        else if (formNumber==0){
            HttpSession session = request.getSession();
            CourseDAO cd= new CourseDAO();
            String[] u= cd.fetchAllCourseCodes();
            System.out.println(u[0]);
            session.setAttribute("courseList", u);
            if(session.getAttribute("studentslist")!=null){
                session.removeAttribute("studentslist");}
            request.setAttribute("identification", u);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/Admin_Pages/StudentsInCourse.jsp");
            rd.forward(request, response);

        }
        else if (formNumber==2){

            int StudentID = Integer.parseInt(request.getParameter("student"));
            System.out.println(StudentID);
            ArrayList<String> courseResponse = new ArrayList<String>();

            RegisteredInDOA rid= new RegisteredInDOA();
            ResultSet r = rid.getCourses(StudentID);



            while(true){
                try {
                    if (!r.next()) {break;}
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    courseResponse.add(r.getString("CourseCode")) ;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }




            }

            HttpSession session = request.getSession();
            System.out.println(courseResponse);

            session.setAttribute("courses", courseResponse);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/Admin_Pages/CourseTakenByStudent.jsp");
            rd.forward(request, response);


        }
        else if (formNumber==3){


            String courseCode = request.getParameter("course");
            System.out.println("here"+courseCode);
            ArrayList<Integer> studentResponse = new ArrayList<Integer>();

            RegisteredInDOA rid= new RegisteredInDOA();
            ResultSet r = rid.getStudents(courseCode);



            while(true){
                try {
                    if (!r.next()) {break;}
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    studentResponse.add(r.getInt("StudentID")) ;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }




            }

            HttpSession session = request.getSession();
            System.out.println(studentResponse);

            session.setAttribute("studentslist",studentResponse );
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/Admin_Pages/StudentsInCourse.jsp");
            rd.forward(request, response);




        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       if(request.getParameter("loginAdmin") != null){

           int adminID =  Integer.parseInt(request.getParameter("EmployementID"));

           HttpSession session = request.getSession();


           try {

              if (adminDOA.verify_Admin(adminID) == 1){


                  response.sendRedirect("/A2_war_exploded/Admin_Pages/AdminPage.jsp");

                  session.setAttribute("verifiedAdmin",adminID);


               }
              else{

                  response.sendRedirect("/A2_war_exploded/Admin_Pages/Admin_Login.jsp");
              }



           } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }


       } else if (request.getParameter("registerAdmin") != null) {

           String EmpID = request.getParameter("EmployementID");
           String firstName = request.getParameter("FirstName");
           String lastName = request.getParameter("LastName");
           String DateOfBirth = request.getParameter("DOB");
           String email= request.getParameter("Email");
           String address = request.getParameter("Address");
           String phoneNumber = request.getParameter("Phone");

           boolean errorFound = false;

           try {
               if (!EmpID.matches("[0-9]+") || EmpID.length() != 8) {

                   request.setAttribute("errorID", "Make sure ID is of 7 numbers long and All Numbers");
                   errorFound = true;
               }else if (adminDOA.verify_Admin(Integer.parseInt(EmpID)) == 1) {

                   request.setAttribute("errorID", "Employement ID already exists");
                   errorFound = true;

               }if(!firstName.matches("^[a-zA-Z]+$")){

                   request.setAttribute("errorFirstName", "Can Only contain Letters");
                   errorFound = true;


               }if(!lastName.matches("^[a-zA-Z]+$")){

                   request.setAttribute("errorLastName", "Can Only contain Letters");
                   errorFound = true;


               }if(!phoneNumber.matches("[0-9]+") ){

                   request.setAttribute("errorPhoneNumber", "A phone Number may only contain Numbers");
                   errorFound = true;


               }

               if(errorFound) {
                   request.setAttribute("employementIDDefault", EmpID);
                   request.setAttribute("firstNameDefault", firstName);
                   request.setAttribute("lastNameDefault", lastName);
                   request.setAttribute("DOBDefault", DateOfBirth);
                   request.setAttribute("emailDefault", email);
                   request.setAttribute("addressDefault", address);
                   request.setAttribute("phoneDefault", phoneNumber);
                   RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/Admin_Pages/AdminRegister.jsp");
                   rd.forward(request, response);
               }else{

                   Admin newAdmin = new Admin(Integer.parseInt(EmpID),firstName,lastName,DateOfBirth,address,email,Integer.parseInt(phoneNumber));

                   adminDOA.registerAdmin(newAdmin);

                   request.setAttribute("registrationMessage", "Admin has been Added");
                   RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/Admin_Pages/AdminRegister.jsp");
                   rd.forward(request, response);


               }



           } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }






       }else if (request.getParameter("createCourse") != null) {

           String courseCode = request.getParameter("CourseCode");
           String title = request.getParameter("Title");
           String semester = request.getParameter("Semester");
           String days = request.getParameter("days");
           String time = request.getParameter("Time");
           String instructor = request.getParameter("instructor");
           String room = request.getParameter("room");
           String startDate = request.getParameter("StartDate");
           String endDate = request.getParameter("EndDate");



           boolean errorFound = false;

           try{

               if(!courseCode.matches("^[a-z]{4}\\d{3}$")){

                   request.setAttribute("errorCourseCode", "Make sure Course code is 4 letters and 3 digits");
                   errorFound = true;

               }
               else if(adminDOA.verifyCourse(courseCode) == 1){
                   request.setAttribute("errorCourseCode", "This Course Already Exists");
                   errorFound = true;

               }
               //add else if check to see if course already exists

               if(!title.matches("^[a-zA-Z\\s]*$")){

                   request.setAttribute("errorTitle", "Make sure Title is only letters");
                   errorFound = true;
               }
               if(!semester.equals("fall") && !semester.equals("winter") && !semester.equals("summer")){

                   request.setAttribute("errorSemester", "The semester must be : fall, winter or summer");
                   errorFound = true;
               }
               if(!days.matches("^(Mon|Tue|Wed|Thu|Fri|Sat|Sun)(-(Mon|Tue|Wed|Thu|Fri|Sat|Sun))+$") ){

                   request.setAttribute("errorDays", "The format must be : Tue-Mon");
                   errorFound = true;
               }
               if(time == null){

                   request.setAttribute("errorTime", "Time cannot be empty");
                   errorFound = true;
               }
               if(!instructor.matches("^[a-zA-Z]+$")){

                   request.setAttribute("errorInstructor", "Instructor can only be letters and not  empty");
                   errorFound = true;
               }
               if(!room.matches("^[a-z]{1,5}-\\d{1,8}$")){

                   request.setAttribute("errorRoom", "Format of room should be:  Building letter followed by a dash followed by room number ");
                   errorFound = true;
               }


               // add 2 more if checks for start date and end date


               if(errorFound){

                   request.setAttribute("courseCodeDefault", courseCode);
                   request.setAttribute("titleCourseCode", title);
                   request.setAttribute("semesterDefault", semester);
                   request.setAttribute("daysDefault", days);
                   request.setAttribute("timeDefault", time);
                   request.setAttribute("instructorDefault", instructor);
                   request.setAttribute("roomDefault", room);
                   request.setAttribute("startDateDefault", startDate);
                   request.setAttribute("endDateDefault", endDate);
                   RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/Admin_Pages/CreateCourse.jsp");
                   rd.forward(request, response);

               }
               else{
                   Date strdate = Date.valueOf(startDate);
                   Date enddate = Date.valueOf(endDate);



                   course newCourse = new course(courseCode,title,semester,days,instructor,room,strdate,enddate,time);

                   adminDOA.createCourse(newCourse);
                   request.setAttribute("courseCreationMessage", "Course has been created");
                   RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/Admin_Pages/CreateCourse.jsp");
                   rd.forward(request, response);




               }





           } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }







       }











    }
}
