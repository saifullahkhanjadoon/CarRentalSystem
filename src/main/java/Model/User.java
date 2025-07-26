
package Model;

import javax.swing.JFrame;

 
public abstract class User {
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phNumber;
    private String pasword; 

    //typr: 0==>Clint
    //      1==>Admin
    //      2==>DeletedClintAccount
    //      3==>DeletedAdminAccount
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }
public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
    public abstract void showList(Database database,JFrame f);
}
