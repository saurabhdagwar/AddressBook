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

    public String getAddress(String address) {
        return address;
    }

    public String getCity(String city) {
        return city;
    }

    public String getState(String state) {
        return state;
    }

    public long getNumber(long phonenumber) {
        return phonenumber;
    }

    public long getzip(long zip) {
        return zip;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setCity(String city){
        this.city = city;
    }
    public void setState(String state){
        this.state = state;
    }

    public void setZip( long zip){
        this.zip = zip;
    }

    public void setNumber( long phonenumber){
        this.phonenumber = phonenumber;
    }
    public String toString() {
        return "Name: " + fname + " " + lname + ", Address: " + address + ", City: " + city + ",State: " + state + ",Phone: " + phonenumber + ",Pin Code: " + zip +" | " ;
    }
}