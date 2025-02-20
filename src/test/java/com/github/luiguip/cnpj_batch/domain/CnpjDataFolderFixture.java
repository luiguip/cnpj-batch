package com.github.luiguip.cnpj_batch.domain;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class CnpjDataFolderFixture {

  public static CnpjDataFolder create() {
    return create(null);
  }

  public static CnpjDataFolder create(Long id) {
    var year = 2020;
    var month = Month.JANUARY;
    var dayOfMonth = 1;
    var hour = 0;
    var minute = 0;
    return new CnpjDataFolder(id, YearMonth.of(year, month),
        LocalDateTime.of(year, month, dayOfMonth, hour, minute));
  }

  public static List<CnpjDataFolder> createList(boolean withId) {
    var cnpjDataFolders = new ArrayList<CnpjDataFolder>();
    cnpjDataFolders.add(
        new CnpjDataFolder(withId ? 1L : null, YearMonth.parse("2025-02"), LocalDateTime.parse("2025-02-08T22:41")));
    cnpjDataFolders.add(
        new CnpjDataFolder(withId ? 2L : null, YearMonth.parse("2025-01"), LocalDateTime.parse("2025-01-11T22:57")));
    cnpjDataFolders.add(
        new CnpjDataFolder(withId ? 3L : null, YearMonth.parse("2024-12"), LocalDateTime.parse("2024-12-30T09:52")));
    cnpjDataFolders.add(
        new CnpjDataFolder(withId ? 4L : null, YearMonth.parse("2024-11"), LocalDateTime.parse("2024-11-13T18:21")));
    cnpjDataFolders.add(
        new CnpjDataFolder(withId ? 5L : null, YearMonth.parse("2024-10"), LocalDateTime.parse("2024-12-30T09:13")));
    return cnpjDataFolders;
  }
}
