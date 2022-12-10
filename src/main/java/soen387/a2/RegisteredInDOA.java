package soen387.a2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RegisteredInDOA {

    public  ResultSet getCourses  (int StudentID) {
        String SELECT_ADMIN_SQL = "SELECT CourseCode FROM Assignment1.RegisteredIn WHERE " + "StudentID='" + StudentID + "';";

        ResultSet result;
        Connection conn = DB_Connection.connectDB();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement((SELECT_ADMIN_SQL));
            System.out.println(preparedStatement);

            result = preparedStatement.executeQuery();
            // System.out.println(result);
            System.out.println(result.isBeforeFirst());

            return result;

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }


        return null;
    }


    public  ResultSet getStudents  (String courseCode) {
        String SELECT_ADMIN_SQL = "SELECT StudentID FROM Assignment1.RegisteredIn WHERE " + "CourseCode='" + courseCode + "';";

        ResultSet result;
        Connection conn = DB_Connection.connectDB();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement((SELECT_ADMIN_SQL));
            System.out.println(preparedStatement);

            result = preparedStatement.executeQuery();
            // System.out.println(result);
            System.out.println(result.isBeforeFirst());

            return result;

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }


        return null;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}