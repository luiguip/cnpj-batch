package com.github.luiguip.cnpj_batch.domain;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class CnpjDataFolderObjectMother {

  public static CnpjDataFolder create() {
    var year = 2020;
    var month = Month.JANUARY;
    var dayOfMonth = 1;
    var hour = 0;
    var minute = 0;
    return new CnpjDataFolder(YearMonth.of(year, month),
        LocalDateTime.of(year, month, dayOfMonth, hour, minute));
  }

  public static List<CnpjDataFolder> createList() {
    var cnpjDataFolders = new ArrayList<CnpjDataFolder>();
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2025-02"), LocalDateTime.parse("2025-02-08T22:41")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2025-01"), LocalDateTime.parse("2025-01-11T22:57")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2024-12"), LocalDateTime.parse("2024-12-30T09:52")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2024-11"), LocalDateTime.parse("2024-11-13T18:21")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2024-10"), LocalDateTime.parse("2024-12-30T09:13")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2024-09"), LocalDateTime.parse("2024-10-03T21:12")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2024-08"), LocalDateTime.parse("2024-10-07T12:57")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2024-07"), LocalDateTime.parse("2024-10-19T03:58")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2024-06"), LocalDateTime.parse("2024-10-18T22:33")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2024-05"), LocalDateTime.parse("2024-10-18T20:53")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2024-04"), LocalDateTime.parse("2024-11-04T12:22")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2024-03"), LocalDateTime.parse("2024-11-04T13:45")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2024-02"), LocalDateTime.parse("2024-11-04T15:17")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2024-01"), LocalDateTime.parse("2024-11-04T17:43")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2023-12"), LocalDateTime.parse("2024-11-04T18:31")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2023-11"), LocalDateTime.parse("2024-11-04T19:51")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2023-10"), LocalDateTime.parse("2024-11-04T22:04")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2023-09"), LocalDateTime.parse("2024-11-04T22:40")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2023-08"), LocalDateTime.parse("2024-11-05T07:01")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2023-07"), LocalDateTime.parse("2024-11-05T10:05")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2023-06"), LocalDateTime.parse("2024-11-05T13:57")));
    cnpjDataFolders.add(
        new CnpjDataFolder(YearMonth.parse("2023-05"), LocalDateTime.parse("2024-11-05T12:33")));
    return cnpjDataFolders;
  }
}
