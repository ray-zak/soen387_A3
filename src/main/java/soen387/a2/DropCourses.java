package soen387.a2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;


@WebServlet("/Drop")
public class DropCourses extends HttpServlet {



    public void init() {
        //message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){


        int std_id = Integer.parseInt(request.getParameter("studentid"));
        System.out.println(std_id);
        int number_of_courses = Integer.parseInt(request.getParameter("numofcourses"));
        System.out.println(number_of_courses);

        HttpSession session = request.getSession();
        session.setAttribute("studentid" , std_id);

        HashMap<String, Boolean> droppedcourses = new HashMap<String, Boolean>();

        for (int i=1;i<=number_of_courses;i++){

            String coursecode = request.getParameter("course"+i);
            System.out.println(coursecode);
            boolean dropped = StudentDAO.DropACourse(std_id,coursecode);
            droppedcourses.put(coursecode , dropped);
        }

        request.setAttribute("droppedcourses" , droppedcourses);

        RequestDispatcher rd = request.getRequestDispatcher("/Confirmation.jsp");

        try{
            rd.forward(request,response);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response){

    }

    public void destroy() {

    }

}
