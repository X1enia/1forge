package lesson10;

public class TemperatureCovnerter {
    public static void main(String[] args) {
        TempConv tc = new TempConv();
        double resultC = tc.convertToCelsius(100, Scale.FAHRENHEIT);
        double resultCC = tc.convertToCelsius(100, Scale.KELVIN);
        System.out.println("Результат конвертирования из Фаренгейта в Цельсия " + resultC);
        System.out.println("Результат конвертирования из Кельвина в Цельсия " + resultCC);

        double resultF = tc.convertToFahrenheit(100, Scale.CELSIUS);
        double resultFF = tc.convertToFahrenheit(100, Scale.KELVIN);
        System.out.println("Результат конвертирования из Цельсия в Фаренгейта " + resultF);
        System.out.println("Результат конвертирования из Кельвина в Фаренгейта " + resultFF);

        double resultK = tc.convertToKelvin(100, Scale.CELSIUS);
        double resultKK = tc.convertToKelvin(100, Scale.FAHRENHEIT);
        System.out.println("Результат конвертирования из Цельсия в Кельвина " + resultK);
        System.out.println("Результат конвертирования из Фаренгейта в Кельвина " + resultKK);
    }
}
