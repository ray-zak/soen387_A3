package soen387.a2;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class CourseDAO {

    private static Connection conn= null;

    private static HashMap<String,course> Allcourses = new HashMap<String,course>();
    private static HashMap<String, List<Student>> StudentsRegisteredinCourse= new HashMap<String,List<Student>>();



    public static void loadAllCourses(){

        conn = DB_Connection.connectDB();
        String query1 = "Select * from Assignment1.course";
//        String query2 = "select CourseCode, Student.StudentID, FirstName, LastName,Address,Email,Phone, DOB \n" +
//                "from Assignment1.Registeredin , Assignment1.Student\n" +
//                "where Registeredin.StudentID = Student.StudentID;";

        String query2 =  " select CourseCode, Student.StudentID, FirstName, LastName,Address,Email,Phone, DOB " +
                "from Assignment1.Person ,Assignment1.Registeredin , Assignment1.Student " +
                "where Registeredin.StudentID = Student.StudentID and Student.PersonID = Person.idPerson;";
        try{
            PreparedStatement stmt = conn.prepareStatement(query1);
            ResultSet result1 = stmt.executeQuery();

            while(result1.next()){

                String coursecode = result1.getString("CourseCode");
                String title = result1.getString("Title");
                String semester = result1.getString("Semester");
                String days = result1.getString("days");
                String time = result1.getString("Time");
                String instructor = result1.getString("instructor");
                String room = result1.getString("room");
                Date startdate = result1.getDate("StartDate");
                Date enddate = result1.getDate("EndDate");
                course course = new course(coursecode,title,semester,days,instructor,room,startdate,enddate,time);
                Allcourses.put(coursecode, course);

            }

            PreparedStatement stmt2 = conn.prepareStatement(query2);
            ResultSet result2 = stmt2.executeQuery();

            while(result2.next()){
                String coursecode = result2.getString("CourseCode");

                int std_id = result2.getInt("StudentID");
                String firstname = result2.getString("FirstName");
                String lastname = result2.getString("LastName");
                Date Dob = result2.getDate("DOB");
                String address = result2.getString("Address");
                String email = result2.getString("Email");
                int phone = result2.getInt("phone");


                Student st = new Student(std_id,firstname,lastname,Dob,address,email,phone);
                List<Student> studentlst = new ArrayList<Student>();
                studentlst.add(st);
                StudentsRegisteredinCourse.put(coursecode,studentlst);


            }

        }
        catch (SQLException e){
            System.out.println("Error"+ e.getMessage());
        }

    }


    public static List<course> getAllCoursesPerTerm (String term){

        ArrayList<course> courses= new ArrayList<course>();

        ResultSet result = null;
        conn = DB_Connection.connectDB();

        String query = "select * from Assignment1.Course where Semester = ?";

        try{

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,term);
            result = stmt.executeQuery();


            while(result.next()){
                String coursecode = result.getString("CourseCode");
                String title = result.getString("Title");
                String semester = result.getString("Semester");
                String days = result.getString("days");
                String time = result.getString("Time");
                String instructor = result.getString("instructor");
                String room = result.getString("room");
                Date startdate = result.getDate("StartDate");
                Date enddate = result.getDate("EndDate");
                course course = new course(coursecode,title,semester,days,instructor,room,startdate,enddate,time);

                courses.add(course);

            }


        }

        catch (Exception e){
            System.out.println("Error"+ e.getMessage());
        }
        DB_Connection.disconnectDB();
        return courses;
    }


    public static course getCourseByCourseCode(String coursecode){
        loadAllCourses();
        return Allcourses.get(coursecode);
    }


    public String[] fetchAllCourseCodes(){
        String SELECT_ADMIN_SQL= "select CourseCode from Assignment1.Course";

        ResultSet result;
        Connection conn = DB_Connection.connectDB();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement((SELECT_ADMIN_SQL));
            System.out.println(preparedStatement);

            result = preparedStatement.executeQuery();
            // System.out.println(result);
            System.out.println(result.isBeforeFirst());



            ArrayList<String> courseList= new ArrayList<String>();

            RegisteredInDOA rid= new RegisteredInDOA();




            while(true){
                try {
                    if (!result.next()) {break;}
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    courseList.add(result.getString("CourseCode")) ;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }




            }
            String[] TempArr = new String[courseList.size()];
            TempArr = courseList.toArray(TempArr);

            return TempArr;


        } catch (SQLException e) {
            // process sql exception
            /// printSQLException(e);
        }


        return null;

    }



}
