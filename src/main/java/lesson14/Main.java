package lesson14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int SUBS_SIZE = 1000;

    public static void main(String[] args) {

        List<PhoneBook> subs = new ArrayList<>();
        for (int i = 0; i < SUBS_SIZE; i++) {
            subs.add(getPhoneBook());
        }

        for (int i = 0; i < 100; i++) {
            setupContacts(subs);
        }
        Integer maximumContacts = subs.stream()
                .mapToInt(p -> p.getContacts().size())
                .max().orElse(0);
        System.out.println(maximumContacts);
    }

    private static void setupContacts(List<PhoneBook> subs) {
        Random random = new Random();
        int high = subs.size();
        for (int i = 0; i < SUBS_SIZE; i++) {
            if (random.nextInt(50) > 35) {
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
