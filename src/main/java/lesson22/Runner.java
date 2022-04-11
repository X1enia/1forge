package lesson22;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson22.Exception.MandatoryParameterSkippedException;
import lesson22.dto.Dto;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class Runner {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages", Locale.ENGLISH);
    private static final String EXIT = RESOURCE_BUNDLE.getString("app.exit");
    private static final String APP_ID = System.getenv("appId");
    private static final String WEATHER = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        final String appId = getAppId();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println(RESOURCE_BUNDLE.getString("app.title"));

        while (inputScanner.hasNextLine()) {
            String cityName = inputScanner.nextLine();
            if (EXIT.equalsIgnoreCase(cityName)) {
                return;
            }
            String translatedCityName = getCityEn(cityName);
            Double cityTemperature = getCityTemperature(appId, translatedCityName);
            System.out.printf(RESOURCE_BUNDLE.getString("app.result"), cityName, cityTemperature);
            System.out.printf(RESOURCE_BUNDLE.getString("app.next"));
        }
    }

    private static Double getCityTemperature(String appId, String translatedCityName) throws MalformedURLException {
        URL apiUrl = new URL(String.format(WEATHER, translatedCityName, appId));
        try (InputStream is = (apiUrl.openStream())) {
            Dto dto = objectMapper.readValue(is, Dto.class);
            return dto.getMain().getTemp();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getAppId() {
        return Optional.ofNullable(APP_ID)
                .orElseThrow(() -> new MandatoryParameterSkippedException(RESOURCE_BUNDLE.getString("app.errorParameter")));
    }

    private static String getCityEn(String cityName) {
        try {
            return RESOURCE_BUNDLE.getString(cityName);
        } catch (Exception e) {
            e.printStackTrace();
            return "Tver";
        }
    }
}
