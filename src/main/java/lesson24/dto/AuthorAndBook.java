package lesson24.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorAndBook {
    @CsvBindByName(column = "ISBN")
    private String isbn;
    @CsvBindByName(column = "Title")
    private String title;
    @CsvBindByName(column = "URL")
    private String URL;
    @CsvBindByName(column = "PageNumber")
    private Integer pageNumber;
    @CsvBindByName(column = "Author")
    private String author;
    @CsvBindByName(column = "Price")
    private BigDecimal price;
    @CsvBindByName(column = "Year")
    private Integer year;
}
