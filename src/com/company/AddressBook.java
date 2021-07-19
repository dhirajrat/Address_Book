package com.company;

class Contacts
{
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String pNum;
    private String email;

    public Contacts(String firstName, String lastName, String address, String city, String state, String zip, String pNum, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.pNum = pNum;
        this.email = email;
    }
}

public class AddressBook {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome");
    }
}