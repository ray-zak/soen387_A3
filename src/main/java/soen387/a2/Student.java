package soen387.a2;



import java.sql.Date;
import java.util.LinkedList;

public class Student {

    private int ID;
    private String Firstname;
    private String Lastname;
    private Date DOB;
    private String Address;
    private String Email;
    private int phone;

    private LinkedList<course> courses = new LinkedList<course>();




    public Student (int ID, String firstname, String lastname, Date DOB, String address , String Email, int phone){
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

    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.Lastname = lastname;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


    public String getFirstname() {
        return this.Firstname;
    }

    public String getLastname() {
        return this.Lastname;
    }

    public Date getDOB() {
        return this.DOB;
    }

    public String getAddress() {
        return this.Address;
    }

    public String getEmail() {
        return this.Email;
    }

    public int getPhone() {
        return this.phone;
    }

    public LinkedList<course> getcourses(){
        return this.courses;
    }

    public void setcourses(LinkedList<course> courses){
        this.courses = courses;
    }




}
