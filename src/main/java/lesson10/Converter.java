package lesson10;

public interface Converter {
    double convertToCelsius(double temp, Scale scale);

    double convertToFahrenheit(double temp, Scale scale);

    double convertToKelvin(double temp, Scale scale);
}
