package lesson14;

import java.util.*;

public class Main {

    private static final int SUBS_SIZE = 10000;

    public static void main(String[] args) {

        List<PhoneBook> subs = new ArrayList<>();
        for (int i = 0; i < SUBS_SIZE; i++) {
            subs.add(getPhoneBook());
        }

        for (int i = 0; i < 100; i++) {
            setupContacts(subs);
        }

        HashMap<PhoneBook, Integer> contacts = new HashMap<>();

        subs.forEach(sub -> sub.getContacts().forEach(contact -> {
            if (contacts.get(contact) != null) {
                Integer currentCount = contacts.get(contact) + 1;
                contacts.put(contact, currentCount);
            } else {
                contacts.put(contact, 1);
            }
        }));

        Map.Entry<PhoneBook, Integer> maxContact = contacts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        if (maxContact != null) {
            System.out.println(maxContact.getKey().getName());
        }
    }

    private static void setupContacts(List<PhoneBook> subs) {
        Random random = new Random();
        int high = subs.size();
        for (int i = 0; i < SUBS_SIZE; i++) {
            if (random.nextInt(50) > 20) {
                int inContact = random.nextInt(high);
                int outContact = random.nextInt(high);
                if (inContact != outContact) {
                    subs.get(inContact).getContacts().add(subs.get(outContact));
                }
            }
        }
    }

    public static String getRandomPhone() {
        final int PHONE_NUMBER_LENGTH = 10;
        String s = "123456789";
        StringBuffer phoneNumber = new StringBuffer();

        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }
        return String.format("+7%s", phoneNumber);
    }

    public static String getRandomName() {
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
