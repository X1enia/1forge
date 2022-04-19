package lesson24.jdbc;

import lesson24.dto.AuthorAndBook;
import org.apache.commons.lang.StringUtils;
import lesson24.BookRunner;
import lesson24.dto.AuthorDto;
import lesson24.dto.BooksDto;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@UtilityClass
public class BooksDb {
    private final Properties DB_SETTINGS = new Properties();

    static {
        try {
            DB_SETTINGS.load(BookRunner.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows(SQLException.class)
    public void dropIfExists() {
        try (final Connection connection = getConnection();
             final PreparedStatement dropIfExistsTableBooks = connection.prepareStatement("drop table if exists books");
             final PreparedStatement dropIfExistsTableAuthors = connection.prepareStatement("drop table if exists authors")) {
            dropIfExistsTableBooks.execute();
            dropIfExistsTableAuthors.execute();
        }
    }

    @SneakyThrows(SQLException.class)
    public void createTable() {
        try (final Connection connection = getConnection();
             final PreparedStatement dropIfExistsTableBooks = connection.prepareStatement
                     (""" 
                             create table authors
                             (
                                 id   int auto_increment,
                                 name varchar(100) not null unique,
                                 constraint authors_pk
                                     primary key (id)
                             );
                             """
                     );
             final PreparedStatement dropIfExistsTableAuthors = connection.prepareStatement
                     ("""
                             create table books
                             (
                                 id         int auto_increment,
                                 isbn       varchar(20)   not null unique,
                                 title      varchar(100)  not null,
                                 URL        varchar(4000) null,
                                 pageNumber int           not null,
                                 price      numeric       not null,
                                 year       int           not null,
                                 author_id int           not null,
                                 constraint books_pk
                                         primary key (id),
                                         constraint books_authors_id_fk
                                         foreign key (author_id) references authors (id)
                                 );
                                 """
                     )) {
            dropIfExistsTableBooks.execute();
            dropIfExistsTableAuthors.execute();
        }
    }

    @SneakyThrows(SQLException.class)
    public Optional<Integer> insertAuthor(AuthorDto author) {
        final String authorName = author.getAuthorName();
        if (StringUtils.isBlank(authorName)) {
            return Optional.empty();
        }
        try (final Connection connection = getConnection();
             final PreparedStatement authorStatement = connection.prepareStatement("insert into authors(name) values(?)");
             final PreparedStatement searchAuthorStatement = connection.prepareStatement("select id from authors where name = ?")

        ) {
            authorStatement.setString(1, authorName);
            authorStatement.execute();
            searchAuthorStatement.setString(1, authorName);
            final ResultSet resultSet = searchAuthorStatement.executeQuery();
            while (resultSet.next()) {
                return Optional.of(resultSet.getInt("id"));
            }
        }
        return Optional.empty();
    }

    @SneakyThrows(SQLException.class)
    public void insertBooks(Integer authorId, BooksDto books) {
        try (final Connection connection = getConnection();
             final PreparedStatement booksStatement = connection.prepareStatement(
                     """
                                 insert into books(isbn, title, URL, pageNumber, price, year, author_id)
                                 values (?, ?, ?, ?, ?, ?, ?)
                                 
                             """

             );
             final PreparedStatement bookStatementWithoutAuthor = connection.prepareStatement(
                     """ 
                                 insert into books(isbn, title, URL, pageNumber, price, year)
                                 values (?, ?, ?, ?, ?, ?)
                             """);
        ) {
            if (authorId != null) {
                booksStatement.setString(1, books.getIsbn());
                booksStatement.setString(2, books.getTitle());
                booksStatement.setString(3, books.getURL());
                booksStatement.setInt(4, books.getPageNumber());
                booksStatement.setBigDecimal(5, books.getPrice());
                booksStatement.setInt(6, books.getYear());
                booksStatement.setInt(7, authorId);
                booksStatement.execute();
            } else {
                bookStatementWithoutAuthor.setString(1, books.getIsbn());
                bookStatementWithoutAuthor.setString(2, books.getTitle());
                bookStatementWithoutAuthor.setString(3, books.getURL());
                bookStatementWithoutAuthor.setInt(4, books.getPageNumber());
                bookStatementWithoutAuthor.setBigDecimal(5, books.getPrice());
                bookStatementWithoutAuthor.setInt(6, books.getYear());
                bookStatementWithoutAuthor.execute();
            }
        }
    }

    @SneakyThrows(SQLException.class)
    public List<AuthorAndBook> searchByTitleOrAuthorName(String text) {
        try (final Connection connection = getConnection();
             final PreparedStatement searchStatement = connection.prepareStatement("""
                         select b.isbn, b.title, b.URL, b.pageNumber, b.price, b.year, a.name from books b
                         left join authors a
                         on b.author_id = a.id
                         where lower(b.title) like ? or lower(a.name) like ?
                         order by b.id
                     """)
        ) {
            searchStatement.setString(1, "%" + text + "%");
            searchStatement.setString(2, "%" + text + "%");
            final ResultSet resultSet = searchStatement.executeQuery();
            List<AuthorAndBook> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new AuthorAndBook(
                        resultSet.getString("isbn"),
                        resultSet.getString("title"),
                        resultSet.getString("URL"),
                        resultSet.getInt("pageNumber"),
                        resultSet.getString("name"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getInt("year")));
            }
            return result;
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password"));
    }
}

