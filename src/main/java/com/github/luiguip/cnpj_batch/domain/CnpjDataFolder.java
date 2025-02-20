package com.github.luiguip.cnpj_batch.domain;

import java.time.LocalDateTime;
import java.time.YearMonth;

public record CnpjDataFolder(YearMonth yearMonth, LocalDateTime lastUpdate) {

}
