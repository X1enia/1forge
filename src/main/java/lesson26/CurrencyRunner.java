package lesson26;

import lesson26.service.Impl.CurrencyGetInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@ComponentScan("lesson26")
public class CurrencyRunner {

    private static final String EXIT = "exit";

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CurrencyRunner.class);
        final CurrencyGetInfo currencyInformer = context.getBean(CurrencyGetInfo.class);
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
            currencyInformer.getCurrencyByCode(text.toUpperCase())
                    .ifPresentOrElse(
                            value -> {
                                System.out.printf("Текущий курс %s равен %.4f рублей\n", text, value);
                                System.out.println("Укажите новый код валюты или завершите работу программы");
                            },
                            () -> System.out.println("Введен несуществующий код валюты. Попробуйте еще!")
                    );
        }
    }
}

