package com.github.luiguip.cnpj_batch.infrastructure.repository.converter;

import jakarta.persistence.AttributeConverter;
import java.time.YearMonth;

public class YearMonthAttributeConverter implements AttributeConverter<YearMonth, String> {

  @Override
  public String convertToDatabaseColumn(YearMonth yearMonth) {
    return yearMonth.toString();
  }

  @Override
  public YearMonth convertToEntityAttribute(String s) {
    return YearMonth.parse(s) ;
  }
}
