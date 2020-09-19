import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    static Scanner scan = new Scanner(System.in);
    public static ArrayList<ContactPerson> people = new ArrayList<ContactPerson>();
    static final int ZERO = 0, ONE = 1, TWO = 2;

    public static void main(String args[]) {
        int choice = 0;
        AddressBook contact = new AddressBook();
        System.out.println("----- Welcome to Address Book Program -----");
        while (choice < 6) {
            System.out.println("\nEnter your choice " +
                    "\n\t 1.Add Contact " +
                    "\n\t 2.PrintContact " +
                    "\n\t 3.Edit Contact " +
                    "\n\t 4.Delete Contact" +
                    "\n\t 6. Exit from menu ");
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
                case 4:
                    contact.deleteContact();
                    break;
            }
        }
    }

    public void addPerson() {
        System.out.println("Enter Person Details to add in contact ");
        System.out.println("\tEnter First name :");
        String fname = scan.next();
        if (checkExist(fname)) {
            System.out.println("Contact is exist, Enter different name ");
        } else {
            System.out.println("\tEnter Last name :");
            String lname = scan.next();
            System.out.println("\tEnter Address :");
            String address = scan.next();
            System.out.println("\tEnter City :");
            String city = scan.next();
            System.out.println("\tEnter State :");
            String state = scan.next();
            System.out.println("\tEnter Zip code :");
            long zip = scan.nextLong();
            System.out.println("\tEnter Phone number :");
            long phonenumber = scan.nextLong();

            ContactPerson person1 = new ContactPerson(fname, lname, address, city, state, zip, phonenumber);
            people.add(person1);
        }
    }
    public void editContact() {
        if (people.isEmpty()) {
            System.out.println("There are no contacts to edit ");
        } else {
            String fname, lname, address, city, state;
            long phone, zip;
            int id;
            int count = ZERO;
            for (ContactPerson contact : people) {
                System.out.println("ID: #" + people.indexOf(contact) + " : " + contact);
            }
            System.out.println(" Enter ID of contact to Edit : ");
            id = scan.nextInt();
            System.out.println(people.get(id));
            System.out.println("What You Want to edit...\n \t 1. Address \t 2. Mobile number");
            int choice = scan.nextInt();
            switch (choice) {
                case ONE:
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
                case TWO:
                    System.out.println("Enter Mobile number");
                    phone = scan.nextLong();
                    people.get(id).setNumber(phone);
                    break;
                default:
                    System.out.println("Please Enter Valid Option");
                    editContact();
            }
        }
    }
    public void deleteContact() {
        if (people.isEmpty()) {
            System.out.println("There is no contact to delete");
        } else {
            System.out.println("Enter First name to remove contact ");
            String fname = scan.next();
            for (int count = ZERO; count < people.size(); count++) {
                if (people.get(count).getfname().equals(fname)) {
                    people.remove(people.get(count));
                }
            }
        }
    }

    public void printContact() {
        if (people.isEmpty()) {
            System.out.println("There are no contact to print ");
        } else {
            for (ContactPerson contact : people) {
                System.out.println("Printing Contacts ");
                System.out.println(contact);
            }
        }
    }

    public boolean checkExist(String name)
    {
        int flag = ZERO;
        for(ContactPerson person : people){
            if(person.getfname().equals(name)){
                flag = 1;
                break;
            }
        }
        if(flag == ONE ){
            return true;
        }
        return false;
    }
}