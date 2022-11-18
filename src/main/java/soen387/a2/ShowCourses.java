package soen387.a2;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.util.*;

@WebServlet("/ShowCourses")
public class ShowCourses extends HttpServlet {
    private String message;

    public void init() {
        //message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(request.getParameter("StudentID"));
        String student_id = request.getParameter("StudentID");

        String term = request.getParameter("select");
        System.out.println(term);

        if( term.equals("*") || student_id.equals("") ){
            String ErrorMsg = "Empty field ";
            request.setAttribute("ErrorMessage", ErrorMsg);
            RequestDispatcher rd= request.getRequestDispatcher("/ErrorPage.jsp");

            try{
                rd.forward(request,response);
            }
            catch (Exception e){
                System.out.println("Error" + e.getMessage());
            }
        }

        int student_id_int = Integer.parseInt(student_id);
        boolean student_exist = StudentDAO.checkStudent(student_id_int);

        if(student_exist){
            List <course> courselst = CourseDAO.getAllCoursesPerTerm(term);
            request.setAttribute("courseList", courselst);
            request.setAttribute("studentID" , student_id);

            HttpSession session = request.getSession();
            session.setAttribute("verified" , student_id);
            RequestDispatcher rd= request.getRequestDispatcher("/Student_Pages/Courses_to_Register.jsp");

            try {
                rd.forward(request,response);
            }
            catch (Exception e){
                System.out.println("Error:"+ e.getMessage());
            }


        }
        // forwarding error message to Error page when the id is invalid
        else{
            String ErrorMsg = "invalid Student ID";
            request.setAttribute("ErrorMessage", ErrorMsg);
            RequestDispatcher rd= request.getRequestDispatcher("/ErrorPage.jsp");

            try{
                rd.forward(request,response);
            }
            catch (Exception e){
                System.out.println("Error: "+ e.getMessage());
            }

        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

    }

    public void destroy() {

    }
}