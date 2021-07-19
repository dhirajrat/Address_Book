package com.company;

import java.util.Scanner;

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

    @Override
    public String toString() {
        return "Contacts{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", pNum='" + pNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

public class AddressBook {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome");
        Scanner sc =new Scanner(System.in);
        String firstName;
        String lastName;
        String address;
        String city;
        String state;
        String zip;
        String pNum;
        String email;
        System.out.println("Enter firstname lastname address city state zip phone number emailID");
        Contacts person1 = new Contacts(firstName= sc.nextLine(),lastName= sc.nextLine(), address= sc.nextLine(),city= sc.nextLine(),state=sc.nextLine(),zip=sc.nextLine(), pNum= sc.nextLine(),email= sc.nextLine());
        System.out.println(person1.toString());
    }
}