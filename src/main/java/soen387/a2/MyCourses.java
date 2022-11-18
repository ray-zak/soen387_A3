package soen387.a2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/MyCourses")
public class MyCourses extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String term = request.getParameter("select");
        String student_id = request.getParameter("StudentID");

        if( term.equals("*") || student_id.equals("") ){
            String ErrorMsg = "Empty fields ";
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


        //List<course> registeredcourses = StudentDAO.getCoursesRegisteredByStudent(student_id_int);

        if(student_exist) {

            HttpSession session = request.getSession();
            session.setAttribute("verified" , student_id);

            List<course> registeredcourses = StudentDAO.getCoursesRegisteredByStudent(student_id_int);


            if(registeredcourses==null){
                request.setAttribute("registeredcourses", registeredcourses);
                request.setAttribute("studentID", student_id);
            }

            else{

                for(int i=0;i<registeredcourses.size();i++){

                    if(!registeredcourses.get(i).getSemester().equals(term)){
                        registeredcourses.remove(i);
                    }
                }

                request.setAttribute("registeredcourses", registeredcourses);
                request.setAttribute("studentID", student_id);
            }

            try{
                    RequestDispatcher rd = request.getRequestDispatcher("/Student_Pages/Courses_to_Drop.jsp");
                    rd.forward(request,response);
            }

            catch (Exception e){
                    System.out.println(e.getMessage());
                }

        }

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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

    }
}
