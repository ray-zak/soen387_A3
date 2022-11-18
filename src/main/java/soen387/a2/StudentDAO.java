package soen387.a2;






import java.sql.*;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;

public class StudentDAO {

    private static Connection conn= null;

    private static HashMap<Integer , Student> AllStudents = new HashMap<Integer , Student>();
    private static HashMap<Integer,List<course>> RegisteredCoursesByStudent = new HashMap<Integer,List<course>>();




    private static void LoadAllStudents(){

        AllStudents.clear();
        RegisteredCoursesByStudent.clear();

        conn = DB_Connection.connectDB();

        String query1 = "Select * from Assignment1.Student";
        String query2 = "Select StudentID, Course.CourseCode, Title, Semester,days,Time,instructor,room,StartDate,EndDate\n" +
                " from Assignment1.Course,Assignment1.Registeredin where Registeredin.CourseCode = Course.CourseCode;";



        try {
            PreparedStatement stmt = conn.prepareStatement(query1);
            ResultSet result1 = stmt.executeQuery();

            while (result1.next()) {
                int std_id = result1.getInt("StudentID");
                String firstname = result1.getString("FirstName");
                String lastname = result1.getString("LastName");
                Date Dob = result1.getDate("DOB");
                String address = result1.getString("Address");
                String email = result1.getString("Email");
                int phone = result1.getInt("phone");

                Student st = new Student(std_id, firstname, lastname, Dob, address, email, phone);
                AllStudents.put(std_id, st);
            }
        }
            catch (SQLException e){
                System.out.println("Error:"+ e.getMessage());
            }

        try{

            PreparedStatement stmt2 = conn.prepareStatement(query2);
            ResultSet result2 = stmt2.executeQuery();

           while(result2.next()){

               int std_id = result2.getInt("StudentID");

                       String coursecode = result2.getString("CourseCode");
                       String title = result2.getString("Title");
                       String semester = result2.getString("Semester");
                       String days = result2.getString("days");
                       Time time = result2.getTime("Time");
                       String instructor = result2.getString("instructor");
                       String room = result2.getString("room");
                       Date startdate = result2.getDate("StartDate");
                       Date enddate = result2.getDate("EndDate");

                       course course = new course(coursecode,title,semester,days,instructor,room,startdate,enddate,time);

                        if(RegisteredCoursesByStudent.get(std_id)==null){
                            List<course> registeredcourses = new ArrayList<course>();
                            registeredcourses.add(course);
                            RegisteredCoursesByStudent.put(std_id,registeredcourses);
                        }

                        else{

                            List<course> Registeredcourses = RegisteredCoursesByStudent.get(std_id);

                            for(int i=0;i<Registeredcourses.size();i++){

                                if(Registeredcourses.get(i).getCourseCode().equals(coursecode)){
                                    Registeredcourses.remove(Registeredcourses.get(i));

                                }

                            }
                            Registeredcourses.add(course);
                            RegisteredCoursesByStudent.put(std_id,Registeredcourses);

                        }



           }


        }
        catch (SQLException e){
            System.out.println("Error:"+ e.getMessage());
        }
        DB_Connection.disconnectDB();


    }


    public static boolean checkStudent(int StudentId){

        boolean Studentexist = false;

        conn = DB_Connection.connectDB();
        String query = "Select StudentID from Assignment1.Student where StudentID = ?";

        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,StudentId);
            ResultSet result = stmt.executeQuery();

            System.out.println(result.toString());

            if(result.next()){
                Studentexist= true;
            }

        }
        catch (SQLException e){
            System.out.println("Error:"+ e.getMessage());
        }

        return Studentexist;
    }







    public static String Registeration(int studentid, String courseCode){

        LoadAllStudents();
        String msg = "";
        List<course> lst = RegisteredCoursesByStudent.get(studentid);

        if(lst!=null){

            if (lst.size() == 5) {
                msg = "cannot register more than 5 courses";
                return msg;
            }


            for (int i = 0; i < lst.size(); i++) {
                if (lst.get(i).getCourseCode().equals(courseCode)) {
                    // return "You are already registered in this course";
                    msg = "You are already registered in this course";
                    return msg;
                }


            }
        }

        course c = CourseDAO.getCourseByCourseCode(courseCode);
        Date currentdate = Date.valueOf(LocalDate.now());
        Date startdate = c.getStartDate();

        Integer currentmonth = currentdate.toLocalDate().getMonth().getValue();
        Integer currentDay = currentdate.toLocalDate().getDayOfMonth();
        Integer currentyear = currentdate.toLocalDate().getYear();

        System.out.println(currentDay+" "+currentmonth+" "+currentyear);
        Integer startmonth = startdate.toLocalDate().getMonth().getValue();
        Integer startday = startdate.toLocalDate().getDayOfMonth();
        Integer startyear = startdate.toLocalDate().getYear();

        System.out.println(startday+" "+startmonth+" "+startyear);

        if( (currentyear>startyear) || (currentyear==startyear && currentmonth>startmonth) || (currentyear==startyear && currentmonth==startmonth && currentDay-startday>7)){
            msg= "registeration deadline has been passed.";
            return msg;
        }



        else{
            conn = DB_Connection.connectDB();
            String query = "insert into Assignment1.Registeredin (StudentID, CourseCode) values (?,?)";
            try{
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1,studentid);
                stmt.setString(2,courseCode);
                stmt.executeUpdate();

                msg= "registered successfully";
            }

            catch (SQLException e){
                System.out.println(e.getMessage());
            }

            DB_Connection.disconnectDB();

            return msg;
        }



    }

public static List<course> getCoursesRegisteredByStudent(int studentid){

        LoadAllStudents();
        return RegisteredCoursesByStudent.get(studentid);

}

public static boolean DropACourse(int studentid,String coursecode){

        boolean dropped = false;

        String query = "Delete from Assignment1.Registeredin where StudentID = ? and CourseCode = ?";
        conn = DB_Connection.connectDB();

        try{
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1,studentid);
        stmt.setString(2,coursecode);
        stmt.executeUpdate();
        dropped =true;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        DB_Connection.disconnectDB();

        return dropped;

}






}
