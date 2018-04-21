package com.perfect.team.rest.impl.converter;

import java.util.Date;
import org.dozer.DozerConverter;
import org.springframework.stereotype.Component;

@Component
public class LongToDateConverter extends DozerConverter<Long, Date> {

  public LongToDateConverter() {
    super(Long.class, Date.class);
  }

  @Override
  public Date convertTo(Long source, Date destination) {
    if (source != null) {
      return new Date(source);
    }
    return null;
  }

  @Override
  public Long convertFrom(Date source, Long destination) {
    if (source != null) {
      return source.getTime();
    }
    return null;
  }
}
