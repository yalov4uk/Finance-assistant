package com.perfect.team.rest.impl.converter;

import com.perfect.team.business.model.Category.Type;
import org.dozer.DozerConverter;

public class CategoryTypeToStringConverter extends DozerConverter<Type, String> {

  public CategoryTypeToStringConverter() {
    super(Type.class, String.class);
  }

  @Override
  public String convertTo(Type source, String destination) {
    return source.toString().toLowerCase();
  }

  @Override
  public Type convertFrom(String source, Type destination) {
    if (source != null) {
      return Type.valueOf(source.toUpperCase());
    }
    return null;
  }
}
