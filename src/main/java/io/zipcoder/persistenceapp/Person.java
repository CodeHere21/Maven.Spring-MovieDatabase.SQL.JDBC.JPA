package io.zipcoder.persistenceapp;


import java.util.Date;


public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String mobile;
    private Date birthday;
    private int homeId;

    public Person() {
    }


    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getFIRST_NAME() {
        return firstName;
    }

    public void setFIRST_NAME(String firstName) {
        this.firstName = firstName;
    }

    public String getLAST_NAME() {
        return lastName;
    }

    public void setLAST_NAME(String lastName) {
        this.lastName = lastName;
    }

    public String getMOBILE() {
        return mobile;
    }

    public void setMOBILE(String mobile) {
        this.mobile = mobile;
    }

    public Date getBIRTHDAY() {
        return birthday;
    }

    public void setBIRTHDAY(Date birthday) {

        this.birthday = birthday;
    }

    public int getHOME_ID() {
        return homeId;
    }

    public void setHOME_ID(int homeId) {
        this.homeId = homeId;
    }
}