package soen387.a2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/Register")
public class RegisterCourses extends HttpServlet {

    public void init() {
        //message = "Hello World!";
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException{


        System.out.println(request.getParameter("studentid"));
        System.out.println(request.getParameter("numofcourses"));
        int std_id = Integer.parseInt(request.getParameter("studentid"));
        int courses_num = Integer.parseInt(request.getParameter("numofcourses"));

        //System.out.println(courses_num);
        //System.out.println(request.getParameter("course1"));

        HashMap<String,String> CoursesToEnroll= new HashMap<String,String>();

        for (int i=1;i<=courses_num;i++){
            String coursecode = request.getParameter("course"+i);

            String msg = StudentDAO.Registeration(std_id, coursecode);
            CoursesToEnroll.put(coursecode,msg);

        }



            request.setAttribute("CoursesToEnroll" , CoursesToEnroll );
        RequestDispatcher rd = request.getRequestDispatcher("/Confirmation.jsp");

        try{
            rd.forward(request,response);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException{

    }
    public void destroy() {

    }

}
