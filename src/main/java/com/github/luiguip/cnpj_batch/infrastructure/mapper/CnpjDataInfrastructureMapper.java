package com.github.luiguip.cnpj_batch.infrastructure.mapper;

import com.github.luiguip.cnpj_batch.domain.CnpjDataFolder;
import com.github.luiguip.cnpj_batch.infrastructure.repository.entity.CnpjDataFolderEntity;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class CnpjDataInfrastructureMapper {

  public List<CnpjDataFolder> map(Elements trs) {
    Objects.requireNonNull(trs);
    return trs.stream().flatMap(this::elementToCnpjDataFolder).toList();
  }

  public List<CnpjDataFolder> map(List<CnpjDataFolderEntity> entities) {
    Objects.requireNonNull(entities);
    return entities.stream().map(this::map).toList();
  }

  public CnpjDataFolder map(CnpjDataFolderEntity entity) {
    Objects.requireNonNull(entity);
    return new CnpjDataFolder(entity.getId(), entity.getYearMonth(), entity.getLastUpdate());
  }

  private Stream<CnpjDataFolder> elementToCnpjDataFolder(Element element) {
    try {
      var rawYearMonth = element.select("td").get(1).text().trim();
      var rawLastUpdate = element.select("td").get(2).text().trim();
      var yearMonth = YearMonth.parse(rawYearMonth.replace("/", ""));
      var lastUpdate = LocalDateTime.parse(rawLastUpdate,
          DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
      return Stream.of(new CnpjDataFolder(null, yearMonth, lastUpdate));
    } catch (IndexOutOfBoundsException | DateTimeParseException e) {
      return Stream.empty();
    }
  }

  public CnpjDataFolderEntity map(CnpjDataFolder cnpjDataFolder) {
    return new CnpjDataFolderEntity(cnpjDataFolder.id(), cnpjDataFolder.yearMonth(), cnpjDataFolder.lastUpdate());
  }

  public void map(CnpjDataFolderEntity retrievedEntity, CnpjDataFolderEntity entity) {
    if(!retrievedEntity.getLastUpdate().equals(entity.getLastUpdate())) {
      retrievedEntity.setLastUpdate(entity.getLastUpdate());
    }
  }
}
