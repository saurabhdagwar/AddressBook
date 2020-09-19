import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    static Scanner scan = new Scanner(System.in);
    public static ArrayList<ContactPerson> people = new ArrayList<ContactPerson>();
    public static ArrayList<String> peopleCities = new ArrayList<>();
    public static ArrayList<String> peopleStates = new ArrayList<>();
    static final int ZERO = 0, ONE = 1, TWO = 2;

    public static void main(String args[]) {
        int choice = 0;
        AddressBook contact = new AddressBook();
        System.out.println("----- Welcome to Address Book Program -----");
        while (choice < 9) {
            System.out.println("\nEnter your choice " +
                    "\n\t 1.Add Contact " +
                    "\n\t 2.PrintContact " +
                    "\n\t 3.Edit Contact " +
                    "\n\t 4.Delete Contact" +
                    "\n\t 5. Sorting by First Name" +
                    "\n\t 6. Sorting by City Name" +
                    "\n\t 7. View Cities and State of Contacts " +
                    "\n\t 8. Search contacts in Cities and States " +
                    "\n\t 9. Exit from menu ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    contact.addPerson();
                    break;
                case 2:
                    System.out.println("Printing All Contacts ");
                    contact.printContact();
                    break;
                case 3:
                    contact.editContact();
                    break;
                case 4:
                    contact.deleteContact();
                    break;
                case 5:
                    contact.sortByName();
                    break;
                case 6:
                    contact.sortByCity();
                    break;
                case 7:
                    contact.viewCityState();
                    break;
                case 8:
                    contact.searchContact();
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

    public void sortByName() {
        String tmpfname, tmplname, tmpaddr, tmpcity, tmpstate;
        long tmpzip, tmpmobNo;
        for (int count1 = ZERO; count1 < people.size() - 1; count1++) {
            for (int count2 = count1 + 1; count2 < people.size(); count2++) {
                if (people.get(count1).getfname().compareTo(people.get(count2).getfname()) > 0) {
                    tmpfname = people.get(count2).getfname();
                    people.get(count2).setfname(people.get(count1).getfname());
                    people.get(count1).setfname(tmpfname);
                    tmplname = people.get(count2).getlname();
                    people.get(count2).setlname(people.get(count1).getlname());
                    people.get(count1).setlname(tmplname);
                    tmpaddr = people.get(count2).getAddress();
                    people.get(count2).setAddress(people.get(count1).getAddress());
                    people.get(count1).setAddress(tmpaddr);
                    tmpcity = people.get(count2).getCity();
                    people.get(count2).setCity(people.get(count1).getCity());
                    people.get(count1).setCity(tmpcity);
                    tmpstate = people.get(count2).getState();
                    people.get(count2).setState(people.get(count1).getState());
                    people.get(count1).setState(tmpstate);
                    tmpzip = people.get(count2).getZip();
                    people.get(count2).setZip(people.get(count1).getZip());
                    people.get(count1).setZip(tmpzip);
                    tmpmobNo = people.get(count2).getPhonenumber();
                    people.get(count2).setNumber(people.get(count1).getPhonenumber());
                    people.get(count1).setNumber(tmpmobNo);
                }
            }
        }
    }

    public void sortByCity() {
        String tmpfname, tmplname, tmpaddr, tmpcity, tmpstate;
        long tmpzip, tmpmobNo;
        for (int count1 = ZERO; count1 < people.size() - 1; count1++) {
            for (int count2 = count1 + 1; count2 < people.size(); count2++) {
                if (people.get(count1).getCity().compareTo(people.get(count2).getCity()) > 0) {
                    tmpfname = people.get(count2).getfname();
                    people.get(count2).setfname(people.get(count1).getfname());
                    people.get(count1).setfname(tmpfname);
                    tmplname = people.get(count2).getlname();
                    people.get(count2).setlname(people.get(count1).getlname());
                    people.get(count1).setlname(tmplname);
                    tmpaddr = people.get(count2).getAddress();
                    people.get(count2).setAddress(people.get(count1).getAddress());
                    people.get(count1).setAddress(tmpaddr);
                    tmpcity = people.get(count2).getCity();
                    people.get(count2).setCity(people.get(count1).getCity());
                    people.get(count1).setCity(tmpcity);
                    tmpstate = people.get(count2).getState();
                    people.get(count2).setState(people.get(count1).getState());
                    people.get(count1).setState(tmpstate);
                    tmpzip = people.get(count2).getZip();
                    people.get(count2).setZip(people.get(count1).getZip());
                    people.get(count1).setZip(tmpzip);
                    tmpmobNo = people.get(count2).getPhonenumber();
                    people.get(count2).setNumber(people.get(count1).getPhonenumber());
                    people.get(count1).setNumber(tmpmobNo);
                }
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
                System.out.println(contact);
            }
        }
    }

    public boolean checkExist(String name)
    {
        int flag = ZERO;
        for(ContactPerson person : people){
            if (person.getfname().equals(name)) {
                flag = 1;
                break;
            }
        }
        return flag == ONE;
    }

    public void viewCityState() {
        for (ContactPerson person : people) {
            peopleCities.add(person.getCity());
        }
        for (ContactPerson person : people) {
            peopleStates.add(person.getState());
        }
        System.out.print("Cities of Contacts : \t ");
        System.out.println(peopleCities);

        System.out.print("States of Contacts : \t ");
        System.out.println(peopleStates);

    }

    public void searchContact() {
        int choice = ZERO;
        String city, state;
        System.out.println("\n\t 1.Search Contact in cities :" +
                "\n\t 2. Search Contacts in State ");
        choice = scan.nextInt();
        if (choice == ONE) {
            System.out.printf("Enter Cities : ");
            city = scan.next();
            for(int count = ZERO; count < people.size();count++)
            {
                if(people.get(count).getCity().equals(city)){
                    System.out.println(count+". "+people.get(count).toString());
                }
            }
        }
        else if(choice == TWO){
            System.out.printf("Enter State");
            state = scan.next();
            for(int count = ZERO; count < people.size();count++)
            {
                if(people.get(count).getState().equals(state)){
                    System.out.println(count+". "+people.get(count).toString());
                }
            }
        }
    }

}