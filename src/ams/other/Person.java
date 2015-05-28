/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams.other;

/**
 *
 * @author kieranross
 */
public class Person {
    
    
    //Variables for a Person
    private String firstName;
    private String lastName;
    private String emailAddress;
    
    //Constructors
    
    //Empty Constructor
    public Person(){   
    }
    
    //Constructor with Name
    public Person(String firstname, String lastname){
        
        this.firstName = firstname;
        this.lastName = lastname;
        
    }
    
    
    
    
    //Methods
    
    //Get Name
    /**
     * @return the personName
     */
    public String getPersonFullName() {
        String fullName = firstName + " " + lastName;
        return fullName;
    }
    
    public String getFirstName() {
        
        return firstName;
    }
    
    public String getLastName() {
        
        return lastName;
    }
    
    
    //Set Name
    /**
     * @param firstname Person First Name
     * @param lastname Person Last Name
     */
    public void setPersonName(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
       
    }
    
    //Set Email Address
    /**
     * 
     * @param emailAddress Email address of person
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    //Get Email Address
    /**
     * 
     * @return Email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    

}
