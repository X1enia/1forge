package lesson26.service.Impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConfig {

    @Bean
    public CurrencyGetInfo currencyGetInfo() {
        return new CurrencyGetInfoImpl();
    }
}
