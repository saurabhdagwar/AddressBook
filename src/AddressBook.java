import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static ArrayList<ContactPerson> people = new ArrayList<ContactPerson>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("Welcome to Address Book Program");
        AddressBook contact = new AddressBook();

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
        contact.addPerson(person1);

        contact.printContact();
    }

    public void addPerson(ContactPerson contact) {
        people.add(contact);
    }

    public void printContact() {
        for (ContactPerson contact : people) {
            System.out.println("Printing Contacts ");
            System.out.println(contact);
        }
    }
}