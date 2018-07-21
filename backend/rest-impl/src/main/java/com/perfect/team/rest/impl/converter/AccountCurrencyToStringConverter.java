package com.perfect.team.rest.impl.converter;

import com.perfect.team.common.model.Account.Currency;
import org.dozer.DozerConverter;
import org.springframework.stereotype.Component;

@Component
public class AccountCurrencyToStringConverter extends DozerConverter<Currency, String> {

  public AccountCurrencyToStringConverter() {
    super(Currency.class, String.class);
  }

  @Override
  public String convertTo(Currency source, String destination) {
    if (source != null) {
      return source.toString().toLowerCase();
    }
    return null;
  }

  @Override
  public Currency convertFrom(String source, Currency destination) {
    if (source != null) {
      return Currency.valueOf(source.toUpperCase());
    }
    return null;
  }
}
