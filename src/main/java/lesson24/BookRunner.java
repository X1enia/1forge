package lesson24;

import lesson24.csv.CsvMapper;
import lesson24.dto.AuthorDto;
import lesson24.dto.BooksDto;
import lesson24.jdbc.BooksDb;
import org.apache.commons.lang3.tuple.Pair;
import org.w3c.dom.ls.LSOutput;

import java.util.AbstractMap;
import java.util.Map;

public class BookRunner {

    public static void main(String[] args) {
        System.out.println("Удаление таблицы");
        BooksDb.dropIfExists();
        System.out.println("Создание новой таблицы");
        BooksDb.createTable();
        System.out.println("Наполнение таблицы данными");

        CsvMapper.getInformation().stream().map(authorAndBook ->
                        Pair.of(new AuthorDto(authorAndBook.getAuthor()),
                                new BooksDto((authorAndBook.getIsbn()), authorAndBook.getTitle(), authorAndBook.getURL(),
                                        authorAndBook.getPageNumber(), authorAndBook.getPrice(), authorAndBook.getYear())))
                .forEach(pair ->
                        BooksDb.insertAuthor(pair.getLeft()).ifPresent(authorId ->
                                BooksDb.insertBooks(authorId, pair.getRight()
                                )));

        System.out.println("Программа завершена");
    }

}
