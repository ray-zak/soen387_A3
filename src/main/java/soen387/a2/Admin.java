package soen387.a2;

import java.util.LinkedList;

public class Admin {

    private int ID;
    private String Firstname;
    private String Lastname;

    private String DOB;
    private String Address;
    private String Email;
    private int phone;


    public Admin (int ID, String firstname, String lastname, String DOB, String address , String Email, int phone){
        this.ID = ID;
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.DOB = DOB;
        this.Address = address;
        this.Email = Email;
        this.phone = phone;
    }




    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return this.Firstname;
    }

    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }

    public String getLastname() {
        return this.Lastname;
    }

    public void setLastname(String lastname) {
        this.Lastname = lastname;
    }

    public String getDOB() {
        return this.DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }


    public int getPhone() {return this.phone; }

    public void setPhone(int phone) {this.phone = phone; }


    // creating new course
  public void createCourse(course course){


  }

  // getting student courses
  public LinkedList<course> seeStudentCourses (Student student){

        return student.getcourses();

  }











}
