package lesson22.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dto {

    @JsonProperty
    private WeatherDto main;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WeatherDto {
        private double temp;
    }
}
