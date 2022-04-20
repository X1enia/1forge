package lesson26.service.Impl;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CurrencyGetInfoImpl implements CurrencyGetInfo {

    Map<String, BigDecimal> dictionaryCurrencies = Collections.emptyMap();

    @SneakyThrows
    @PostConstruct
    void init() {
        final DocumentContext context = JsonPath.parse(new URL("https://www.cbr-xml-daily.ru/daily_json.js"));
        final List<Map<String, Object>> currencies = context.read("$.Valute.*", List.class);
        dictionaryCurrencies = currencies.stream()
                .map(it -> Pair.of(it.get("CharCode").toString(), new BigDecimal(it.get("Value").toString())))
                .collect(Collectors.toMap(Pair::getLeft, Pair::getRight));
    }


    @Override
    public Optional<BigDecimal> getCurrencyByCode(String code) {
        return Optional.ofNullable(dictionaryCurrencies.get(code));
    }
}

