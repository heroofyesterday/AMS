/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams;

import ams.other.Person;

/**
 *
 * @author kieranross
 */
public class User extends Person{
    
    //Variables for User
    private int IDnumber;
    private String jobTitle;
    private String Company;
    private String telephoneNumber;
    private String mobileNumber;
    
    //Constructors
    
    //Empty Constructor
    public User() {
        super();
    }
    
    //Constructor with ID Number and Name
    public User(int IDnumber, String firstname, String lastname) {
        super(firstname, lastname);
        this.IDnumber = IDnumber;
    }
    
    //Methods
    
    //Get Methods
    public int getIDnumber() {
        return IDnumber;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompany() {
        return Company;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    
    //Set Methods

    public void setIDnumber(int IDnumber) {
        this.IDnumber = IDnumber;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    
    
    
    
    
    
}
