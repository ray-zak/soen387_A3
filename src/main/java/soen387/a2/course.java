package soen387.a2;

import java.sql.Date;
import java.sql.Time;
import java.util.LinkedList;

public class course {

    private String CourseCode;

    private String Semester;

    private String days;
    private String Title;
    private String instructor;
    private String Room;
    private Date StartDate;
    private Date EndDate;
    private Time  Time;

    private LinkedList<Student> registeredstudents;


    public course (String coursecode,String title,String semester,String days, String instructor, String room , Date startdate, Date enddate , Time time){
        this.CourseCode = coursecode;
        this.Title = title;
        this.Semester= semester;
        this.days= days;
        this.instructor = instructor;
        this.StartDate = startdate;
        this.Room = room;
        this.EndDate = enddate;
        this.Time = time;
        registeredstudents = null;
    }

    public String getDays() {
        return this.days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getCourseCode() {
        return this.CourseCode;
    }


    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getSemester() {
        return this.Semester;
    }

    public void setSemester(String semester) {
        this.Semester = semester;
    }

    public void setCourseCode(String courseCode) {
        this.CourseCode = courseCode;
    }

    public String getInstructor() {
        return this.instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getRoom() {
        return this.Room;
    }

    public void setRoom(String room) {
        this.Room = room;
    }

    public Date getStartDate() {
        return this.StartDate;
    }

    public void setStartDate(Date startDate) {
        this.StartDate = startDate;
    }

    public Date getEndDate() {
        return this.EndDate;
    }

    public void setEndDate(Date endDate) {
        this.EndDate = endDate;
    }

    public Time getTime() {
        return this.Time;
    }

    public void setTime(Time time) {
        this.Time = time;
    }


    public LinkedList<Student> getRegisteredstudents() {
        return this.registeredstudents;
    }

    public void setRegisteredstudents (LinkedList<Student> registeredstudents){
        this.registeredstudents = registeredstudents;
    }
}
