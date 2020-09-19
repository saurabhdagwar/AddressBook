import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    static final int ONE = 1, TWO = 2;
    public static ArrayList<ContactPerson> people = new ArrayList<ContactPerson>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        AddressBook contact = new AddressBook();
        System.out.println("----- Welcome to Address Book Program -----");
        while (choice < 6) {
            System.out.println("Enter your choice \n\t 1.Add Contact \n\t 2.PrintContact \n\t 3.EditContact ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    contact.addPerson();
                    break;
                case 2:
                    contact.printContact();
                    break;
                case 3:
                    contact.editContact();
                    break;
            }
        }
    }

    public void addPerson() {
        System.out.println("Enter Person Details to add in contact ");
        System.out.println("Enter First name :");
        String fname = scan.next();
        System.out.println("Enter Last name :");
        String lname = scan.next();
        System.out.println("Enter Address :");
        String address = scan.next();
        System.out.println("Enter City :");
        String city = scan.next();
        System.out.println("Enter State :");
        String state = scan.next();
        System.out.println("Enter Zip code :");
        long zip = scan.nextLong();
        System.out.println("Enter Phone number :");
        long phonenumber = scan.nextLong();

        ContactPerson person1 = new ContactPerson(fname, lname, address, city, state, zip, phonenumber);
        people.add(person1);
    }

    public void editContact() {
        String fname, lname, address, city, state;
        long phone, zip;
        int id;
        int count = 0;
        for (ContactPerson contact : people) {
            System.out.println("ID: #" + people.indexOf(contact) + " : " + contact);
        }
        System.out.println(" Enter ID of contact to Edit : ");
        id = scan.nextInt();
        System.out.println(people.get(id));
        System.out.println("What You Want to edit...\n \t 1. Address \t 2. Mobile number");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter Address: ");
                address = scan.next();
                people.get(id).setAddress(address);
                System.out.println("Enter City");
                city = scan.next();
                people.get(id).setCity(city);
                System.out.println("Enter State");
                state = scan.next();
                people.get(id).setState(state);
                System.out.println("Enter Zip");
                zip = scan.nextLong();
                people.get(id).setZip(zip);
                break;
            case 2:
                System.out.println("Enter Mobile number");
                phone = scan.nextLong();
                people.get(id).setNumber(phone);
                break;
            default:
                System.out.println("Please Enter Valid Option");
                editContact();
        }
    }

    public void printContact() {
        for (ContactPerson contact : people) {
            System.out.println("Printing Contacts ");
            System.out.println(contact);
        }
    }
}