package lesson24.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BooksDto {
    private String isbn;
    private String title;
    private String URL;
    private Integer pageNumber;
    private BigDecimal price;
    private Integer year;
}
