package soen387.a2;

public class Person {

   // private int ID;
    private String Firstname;
    private String Lastname;

    private String DOB;
    private String Address;
    private String Email;
    private int phone;

    public Person( String firstname, String lastname, String DOB, String address, String email, int phone) {
        //this.ID = ID;
        Firstname = firstname;
        Lastname = lastname;
        this.DOB = DOB;
        Address = address;
        Email = email;
        this.phone = phone;
    }

//    public int getID() {
//        return ID;
//    }
//
//    public void setID(int ID) {
//        this.ID = ID;
//    }


    public String getFirstname() {
        return Firstname;
    }


    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
