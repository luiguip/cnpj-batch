package com.github.luiguip.cnpj_batch.infrastructure.client;

import com.github.luiguip.cnpj_batch.domain.CnpjDataFolder;
import com.github.luiguip.cnpj_batch.domain.InfrastructureException;
import com.github.luiguip.cnpj_batch.infrastructure.mapper.CnpjDataInfrastructureMapper;
import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RfCnpjClient {

  public static final String FOLDER_PATH = "/dados/cnpj/dados_abertos_cnpj/";

  private final String url;

  private final CnpjDataInfrastructureMapper cnpjDataInfrastructureMapper;

  public RfCnpjClient(CnpjDataInfrastructureMapper cnpjDataInfrastructureMapper,
      @Value("${integration.rf-cnpj-path}") String url) {
    this.cnpjDataInfrastructureMapper = cnpjDataInfrastructureMapper;
    this.url = url;
  }

  public List<CnpjDataFolder> findCnpjDataFolders() {
    var fullUrl = url + FOLDER_PATH;
    try {
      var trs = Jsoup.connect(fullUrl).get().select("tr");
      return cnpjDataInfrastructureMapper.map(trs);
    } catch (IOException e) {
      throw new InfrastructureException("Failed to http get %s".formatted(fullUrl), e);
    }
  }
}
