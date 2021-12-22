package lesson14;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhoneBook {

   private String name;
   private String phoneNumber;
   private List<PhoneBook> contacts = new ArrayList<>();

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

    public List<PhoneBook> getContacts() {
        return contacts;
    }

    public void setContacts(List<PhoneBook> contacts) {
        this.contacts = contacts;
    }
}
