package lesson14.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PhoneBookArray {

    public static void main(String [] args) {

        PhoneBook[] subs = new PhoneBook[10000];
        for (int i = 0; i < subs.length; i++) {
            subs[i] = getPhoneBook();
        }

        setupContacts(subs);

        HashMap <PhoneBook, Integer> contacts = getRepeatedContacts(subs);

        Map.Entry<PhoneBook, Integer> maxContact = contacts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        if (maxContact != null) {
            System.out.println(maxContact.getKey().getName());
        }
    }

    private static HashMap <PhoneBook, Integer> getRepeatedContacts(PhoneBook[] subs) {
        HashMap <PhoneBook, Integer> contacts = new HashMap<>();
        for(int i = 0; i < subs.length; i++) {
            PhoneBook[] subContacts = subs[i].getContacts();
            for (int j = 0; j < subContacts.length; j++) {
                if (subContacts[j] != null) {
                    PhoneBook subContact = subContacts[j];
                    if (contacts.get(subContact) != null) {
                        int count = contacts.get(subContact) + 1;
                        contacts.put(subContact, count);
                    } else {
                        contacts.put(subContacts[j], 1);
                    }
                } else {
                    break;
                }
            }
        }
        contacts.remove(null);
        return contacts;
    }

    private static void setupContacts(PhoneBook[] subs) {
        Random random = new Random();
        int high = subs.length;
        for (int i = 0; i < subs.length; i++) {
            if (random.nextInt(50) > 20) {
                int inContact = random.nextInt(high);
                int outContact = random.nextInt(high);
                if (inContact != outContact) {
                    setContactInContactArray(subs[inContact], subs[outContact]);
                }
            }
        }
    }

    private static void setContactInContactArray(PhoneBook in, PhoneBook contact) {
        PhoneBook[] inSubs = in.getContacts();
        int contactsCount = 0;
        for (int i = 0; i < inSubs.length; i++) {
            if (inSubs[i] != null) {
                contactsCount++;
            } else {
                break;
            }
        }
        if (contactsCount < inSubs.length) {
            inSubs[contactsCount] = contact;
        } else {
            throw new ArrayIndexOutOfBoundsException(String.format("Контактная книга переполнена у абонента %s", in.getName()));
        }
    }

    private static String getRandomPhone() {
        final int PHONE_NUMBER_LENGTH = 10;
        String s = "1234567890";
        StringBuffer phoneNumber = new StringBuffer();

        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }
        return String.format("+7%s", phoneNumber);
    }

    private static String getRandomName() {
        final int MAXIMUM_NAME_SYMBOLS = 20;
        String s = "абвгдежзиклмнопрстуфхцчшщъыьэюя";
        Random random = new Random();
        int high = s.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < MAXIMUM_NAME_SYMBOLS; i++) {
            int randomIndex = random.nextInt(high);
            result.append(s.toCharArray()[randomIndex]);
        }
        return result.toString();
    }

    public static PhoneBook getPhoneBook() {
        return new PhoneBook(getRandomName(), getRandomPhone());
    }
}