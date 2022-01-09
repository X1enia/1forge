package lesson14.Arrays;

public class PhoneBook {

    private String name;
    private String phoneNumber;
    private PhoneBook[] contacts = new PhoneBook[10000];

    public PhoneBook(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneBook[] getContacts() {
        return contacts;
    }

    public void setContacts(PhoneBook[] contacts) {
        this.contacts = contacts;
    }
}
