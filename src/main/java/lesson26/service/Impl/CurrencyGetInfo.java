package lesson26.service.Impl;

import java.math.BigDecimal;
import java.util.Optional;

public interface CurrencyGetInfo {

    Optional<BigDecimal> getCurrencyByCode(String code);
}