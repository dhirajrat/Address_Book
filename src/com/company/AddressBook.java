package com.company;

import java.util.*;


/*
    Contact Class
*/
class Contact
{
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String pNum;
    private String email;

    /*
        Contact Class constructor
    */
    public Contact(){
    }

    public Contact(String firstName, String lastName, String city, String state, String pNum, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.pNum = pNum;
        this.email = email;
    }

    /*
        Getter Of First Name
     */
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pNum='" + pNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


class AddressBookOperations
{
    /*
        Add person method
    */
    public static ArrayList<Contact> addAPersonInList(ArrayList<Contact> contacts, int i)
    {
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
        contacts.add(i,new Contact(firstName, lastName, city, state, pNum, email));
        return contacts;
    }

    /*
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

    /*
        edit person method
    */
    public static  ArrayList<Contact> editContactList(ArrayList<Contact> contacts, String fname)
    {
        int m = 0;
        for (Contact contact : contacts) {
            int i = contacts.indexOf(contact);
            if(contacts.get(i).getFirstName().equals(fname)){
                contacts=AddressBookOperations.addAPersonInList(contacts,i);
                contacts.remove(contact);
                m = 1;
                break;
            }
        }
        if(m == 0){
            System.out.println("Contact not found with this name");
        }
        return contacts;
    }

    /*
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

/*
    AdressBook Manager
*/
class AddressBookManager{

    public static ArrayList<Contact> addressBookOperation(ArrayList<Contact> contactList){
        Scanner sc =new Scanner(System.in);



        int maintainOp = 0;
        int i=0;
        while (maintainOp == 0) {
            System.out.println("\n****** Enter the Operation you want perform on AddressBook ******");
            System.out.println("1.Add Contact   2.Edit Contact  3.Delete Contact  4.Print The Contacts  5.Exit from This AddessBook");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add a Contact");
                    contactList = AddressBookOperations.addAPersonInList(contactList, i);
                    i++;
                    break;

                case 2:
                    if(i==0){ System.out.println("No Contact available to edit"); }
                    else {
                        System.out.println("Enter first name of Contact which you want to edit");
                        Scanner sname = new Scanner(System.in);
                        String pname = sname.nextLine();
                        contactList = AddressBookOperations.editContactList(contactList, pname);
                    }
                    break;

                case 3:
                    if(i==0){ System.out.println("No Contact available to delete"); }
                    else {
                        Scanner sdname = new Scanner(System.in);
                        System.out.println("Enter first name of Contact which you want to delete");
                        String dname = sdname.nextLine();
                        contactList = AddressBookOperations.deleteContact(contactList, dname);
                        int check = i-1;
                        if(contactList.size() == check) {
                            i--;
                        }
                    }
                    break;

                case 4:
                    if(i==0){ System.out.println("No Contact available to SHOW"); }
                    else {
                        System.out.println("******** This is the List **********");
                        AddressBookOperations.showPeopleList(contactList);
                    }
                    break;

                case 5:
                    System.out.println("AddressBook Operation --> EXIT <--");
                    maintainOp = 1;
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }

        return contactList;
    }
}

/*
    To manage Multiple AddressBooks created a Contact list Class
 */
class ContactList{
    ArrayList<Contact> aList;

    public ContactList(ArrayList<Contact> aList) {
        this.aList = aList;
    }

    public static Map<String,ArrayList<Contact>> add(String addressBookName,Map<String,ArrayList<Contact>> drive)
    {
        ArrayList<Contact> contactList = new ArrayList<>();
        drive.put(addressBookName,contactList);
        return drive;
    }

}

public class AddressBook {
     /*
        Main Method
      */

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        System.out.println(ANSI_GREEN + " WELCOME! " + ANSI_RESET);
        Scanner sc = new Scanner(System.in);

        Map<String,ArrayList<Contact>> drive = new HashMap<String, ArrayList<Contact>>(10);


        int maintain = 0;
        while(maintain == 0)
        {
            System.out.println("Enter a choice");
            System.out.println("1.Add a new AddressBook   2.Perform Operation on AddressBook  3.Display all AdressBooks   4.EXIT");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter Address Book name to add");
                    Scanner sc1 = new Scanner(System.in);
                    String addressBookName1 = sc1.nextLine();
                    drive = ContactList.add(addressBookName1,drive);
                    System.out.println(addressBookName1+" AddressBook added");

                    break;

                case 2:
                    System.out.println("Enter Address Book name to Perform Operation On");
                    Scanner sc2 = new Scanner(System.in);
                    String addressBookName2 = sc2.nextLine();
                    AddressBookManager.addressBookOperation(drive.get(addressBookName2));
                    break;

                case 3:
                    Set<String> abKeySet = drive.keySet();
                    for(String conName : abKeySet){
                        System.out.println("\n#####  ALL ADDRESSBOOKS-LISTS  #####");
                        System.out.println("AddressBook :::::: "+conName);
                        AddressBookOperations.showPeopleList(drive.get(conName));
                    }
                    break;

                case 4:
                    System.out.println("------>   EXIT   <------");
                    System.out.println(ANSI_RED + "     *-*-*-*  Good Bye!  *-*-*-*     " + ANSI_RESET);
                    maintain = 1;
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;

            }
        }

    }
}
