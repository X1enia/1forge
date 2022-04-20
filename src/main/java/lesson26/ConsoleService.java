package lesson26;

import lesson26.service.Impl.CurrencyGetInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleService {
    private static final String EXIT = "exit";
    private final CurrencyGetInfo currencyService;

    public ConsoleService(CurrencyGetInfo currencyService) {
        this.currencyService = currencyService;
    }

    public void mainMethod() {
        System.out.println("Введите код валюты");
        System.out.printf("или введите %s чтобы завершить работу программы:\n", EXIT);
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final String text = scanner.nextLine();
            if (EXIT.equalsIgnoreCase(text)) {
                return;
            }
            if (StringUtils.isBlank(text)) {
                System.out.println("Введите код валюты");
                continue;
            }
            currencyService.getCurrencyByCode(text.toUpperCase()).ifPresentOrElse(
                    value -> {
                        System.out.printf("Текущий курс %s равен %.4f рублей\n", text, value);
                        System.out.println("Укажите новый код валюты или завершите работу программы");
                    },
                    () -> System.out.println("Введен несуществующий код валюты. Попробуйте еще раз.")
            );
        }
    }
}
