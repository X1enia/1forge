package lesson10;

public class TempConv implements Converter {

    @Override
    public double convertToCelsius(double temp, Scale scale) {
        switch (scale) {
            case FAHRENHEIT:
                return ((temp - 32) / 1.8);
            case KELVIN:
                return (temp - 273.15);
            default:
                return temp;
        }
    }

    @Override
    public double convertToFahrenheit(double temp, Scale scale) {
        switch (scale) {
            case CELSIUS:
                return ((temp * 1.8) + 32);
            case KELVIN:
                return (temp - 273.15) * 1.8 + 32;
            default:
                return temp;
        }
    }

    @Override
    public double convertToKelvin(double temp, Scale scale) {
        switch (scale) {
            case CELSIUS:
                return temp + 273.15;
            case FAHRENHEIT:
                return (temp - 32) / 1.8 + 273.15;
            default:
                return temp;
        }
    }
}
