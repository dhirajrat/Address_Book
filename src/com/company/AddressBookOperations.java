package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *      Class Holds the methods used to  perform different operation on AddressBook
 */
public class AddressBookOperations
{
    /**
        Add person method
    */
    public static ArrayList<Contact> addAPersonInList(ArrayList<Contact> contacts)
    {
        boolean contactPresent = false;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter firstname :");
        String firstName = sc.nextLine();
        System.out.println("Enter lastname :");
        String lastName = sc.nextLine();
        System.out.println("Enter city :");
        String city = sc.nextLine();
        System.out.println("Enter state :");
        String state = sc.nextLine();
        System.out.println("Enter phone number :");
        String pNum = sc.nextLine();
        System.out.println("Enter emailID :");
        String email = sc.nextLine();

        // Checking If Contact Present Or Not If Not present then Add new Contact
        for (Contact contact : contacts){
            if(contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName) ){
                contactPresent = true;
                System.out.println("Contact already Present add another Contact");
            }
        }
        if(contactPresent == false){
            contacts.add(new Contact(firstName, lastName, city, state, pNum, email));
        }

        return contacts;
    }

    /**
        Show person method
    */
    public static void showPeopleList(ArrayList<Contact> contacts)
    {
        System.out.println("----------------------------------------------------------");
        for (Contact contact : contacts) {
            String s = "-- >>" + contact.toString();
            System.out.println(s);
        }
        System.out.println("----------------------------------------------------------");
    }

    /**
        edit person method
    */
    public static  ArrayList<Contact> editContactList(ArrayList<Contact> contacts, String fname)
    {
        int m = 0;
        for (Contact contact : contacts) {
            int i = contacts.indexOf(contact);
            if(contacts.get(i).getFirstName().equals(fname)){
                boolean contactPresent = false;
                Scanner sc =new Scanner(System.in);
                System.out.println("Enter firstname :");
                String firstName = sc.nextLine();
                System.out.println("Enter lastname :");
                String lastName = sc.nextLine();
                System.out.println("Enter city :");
                String city = sc.nextLine();
                System.out.println("Enter state :");
                String state = sc.nextLine();
                System.out.println("Enter phone number :");
                String pNum = sc.nextLine();
                System.out.println("Enter emailID :");
                String email = sc.nextLine();

                // Checking If Contact Present Or Not If Not present then Add new Contact
                contacts.add(i,new Contact(firstName, lastName, city, state, pNum, email));
                m = 1;
                break;
            }
        }
        if(m == 0){
            System.out.println("Contact not found with this name");
        }
        return contacts;
    }

    /**
        delete person method
    */
    public static ArrayList<Contact> deleteContact(ArrayList<Contact> contacts, String fname){
        int m = 0;
        for (Contact contact : contacts) {
            int i = contacts.indexOf(contact);
            if(contacts.get(i).getFirstName().equals(fname)){
                contacts.remove(contact);
                System.out.println("contact of "+fname+" has been deleted");
                m = 1;
                break;
            }
        }
        if(m == 0){
            System.out.println("Contact not found with this name");
        }
        return contacts;
    }
}
