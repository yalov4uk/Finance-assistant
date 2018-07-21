package com.perfect.team.rest.impl.converter;

import com.perfect.team.common.model.Category.Type;
import org.dozer.DozerConverter;
import org.springframework.stereotype.Component;

@Component
public class CategoryTypeToStringConverter extends DozerConverter<Type, String> {

  public CategoryTypeToStringConverter() {
    super(Type.class, String.class);
  }

  @Override
  public String convertTo(Type source, String destination) {
    if (source != null) {
      return source.toString().toLowerCase();
    }
    return null;
  }

  @Override
  public Type convertFrom(String source, Type destination) {
    if (source != null) {
      return Type.valueOf(source.toUpperCase());
    }
    return null;
  }
}
