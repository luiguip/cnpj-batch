package com.github.luiguip.cnpj_batch.infrastructure.entity;

import com.github.luiguip.cnpj_batch.infrastructure.entity.converter.YearMonthAttributeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Objects;

@Entity
@Table(name = "cnpj_data_folder")
public class CnpjDataFolderEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue
  private Long id;
  @Column(name = "year_month")
  @Convert(converter = YearMonthAttributeConverter.class)
  private YearMonth yearMonth;
  @Column(name = "last_update")
  private LocalDateTime lastUpdate;

  public YearMonth getYearMonth() {
    return yearMonth;
  }

  public void setYearMonth(YearMonth yearMonth) {
    this.yearMonth = yearMonth;
  }

  public LocalDateTime getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(LocalDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CnpjDataFolderEntity that)) {
      return false;
    }
    return Objects.equals(yearMonth, that.yearMonth) && Objects.equals(lastUpdate,
        that.lastUpdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(yearMonth, lastUpdate);
  }
}
