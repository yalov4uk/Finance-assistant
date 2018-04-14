package com.perfect.team.rest.impl.converter;

import com.perfect.team.business.model.Account.Currency;
import org.dozer.DozerConverter;

public class AccountCurrencyToStringConverter extends DozerConverter<Currency, String> {

  public AccountCurrencyToStringConverter() {
    super(Currency.class, String.class);
  }

  @Override
  public String convertTo(Currency source, String destination) {
    return source.toString().toLowerCase();
  }

  @Override
  public Currency convertFrom(String source, Currency destination) {
    if (source != null) {
      return Currency.valueOf(source.toUpperCase());
    }
    return null;
  }
}
