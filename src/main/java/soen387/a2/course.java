package soen387.a2;

import java.util.LinkedList;

public class course {

    private String CourseCode;

    private  String Title;

    private String Semester;

    private String Days;
    private String instructor;
    private String Room;
    private String StartDate;
    private String EndDate;
    private String Time;

    private LinkedList<Student> registeredstudents;


    public course (String coursecode,String title ,String semester, String days,String instructor, String room , String startdate, String enddate , String time){
        this.CourseCode = coursecode;
        this.Semester = semester;
        this.Days = days;
        this.Title = title;
        this.instructor = instructor;
        this.StartDate = startdate;
        this.Room = room;
        this.EndDate = enddate;
        this.Time = time;
        registeredstudents = null;
    }


    public String getCourseCode() {
        return this.CourseCode;
    }

    public void setCourseCode(String courseCode) {
        this.CourseCode = courseCode;
    }

    public String getTitle() {return  this.Title;}
    public void setTitle(String title) {this.Title = title;}

    public String getSemester() {return  this.Semester;}
    public void setSemester(String semester) {this.Semester = semester;}

    public String getDays() {return  this.Days;}
    public void setDays(String days) {this.Days = days;}

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

    public String getStartDate() {
        return this.StartDate;
    }

    public void setStartDate(String startDate) {
        this.StartDate = startDate;
    }

    public String getEndDate() {
        return this.EndDate;
    }

    public void setEndDate(String endDate) {
        this.EndDate = endDate;
    }

    public String getTime() {
        return this.Time;
    }

    public void setTime(String time) {
        this.Time = time;
    }


    public LinkedList<Student> getRegisteredstudents() {
        return this.registeredstudents;
    }

    public void setRegisteredstudents (LinkedList<Student> registeredstudents){
        this.registeredstudents = registeredstudents;
    }
}
