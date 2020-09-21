import java.util.Comparator;

public class ContactPerson {
    private String fname;
    private String lname;
    private String address;
    private String city;
    private String state;
    private long phonenumber;
    private long zip;

    public ContactPerson(String fname, String lname, String address, String city, String state, long zip, long phonenumber) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phonenumber = phonenumber;
        this.zip = zip;
    }

    public String getfname() {
        return fname;
    }

    public String getlname() {
        return lname;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setfname(String fname) {
        this.fname = fname;
    }

    public void setlname(String lname) {
        this.lname = lname;
    }

    public void setNumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public static Comparator<ContactPerson> firstNameSorting = (contact1, contact2) -> {
        String firstName = contact1.getfname();
        String firstName2 = contact2.getfname();
        return firstName.compareToIgnoreCase(firstName2);
    };

    public static Comparator<ContactPerson> CitySorting = (contact1, contact2) -> {
        String CityName = contact1.getCity();
        String CityName2 = contact2.getCity();
        return CityName.compareToIgnoreCase(CityName2);
    };

    public String toString() {
        return "Name: " + fname + " " + lname + ", Address: " + address + ", City: " + city + ",State: " + state + ",Phone: " + phonenumber + ",Pin Code: " + zip + " | ";
    }
}