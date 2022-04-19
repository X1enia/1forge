package lesson24;

import lesson24.dto.AuthorAndBook;
import lesson24.jdbc.BooksDb;

import java.util.List;
import java.util.Scanner;

public class BookSearchRunner {
    private static final String EXIT = "выход";

    public static void main(String[] args) {
        System.out.println("Введите название книги или имя автора");
        System.out.printf("Введите %s для завершения работы программы:\n", EXIT);
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final String text = scanner.nextLine();
            if (EXIT.equalsIgnoreCase(text)) {
                return;
            }
            final List<AuthorAndBook> authorAndBooks = BooksDb.searchByTitleOrAuthorName(text);
            System.out.println("Найденные книги:");
            System.out.println(authorAndBooks);
        }
    }
}