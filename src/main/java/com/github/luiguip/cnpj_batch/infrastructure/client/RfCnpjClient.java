package com.github.luiguip.cnpj_batch.infrastructure.client;

import com.github.luiguip.cnpj_batch.configuration.IntegrationConfigurationProperties;
import com.github.luiguip.cnpj_batch.domain.CnpjDataFolder;
import com.github.luiguip.cnpj_batch.domain.InfrastructureException;
import com.github.luiguip.cnpj_batch.infrastructure.mapper.CnpjDataInfrastructureMapper;
import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

@Service
public class RfCnpjClient {

  private final IntegrationConfigurationProperties integrationConfigurationProperties;
  private final CnpjDataInfrastructureMapper cnpjDataInfrastructureMapper;

  public RfCnpjClient(CnpjDataInfrastructureMapper cnpjDataInfrastructureMapper,
      IntegrationConfigurationProperties integrationConfigurationProperties) {
    this.cnpjDataInfrastructureMapper = cnpjDataInfrastructureMapper;
    this.integrationConfigurationProperties = integrationConfigurationProperties;
  }

  public List<CnpjDataFolder> findCnpjDataFolders() {
    var fullUrl = integrationConfigurationProperties.getRfCnpjUrl()
        + integrationConfigurationProperties.getRfCnpjFolderPath();
    try {
      var trs = Jsoup.connect(fullUrl).get().select("tr");
      return cnpjDataInfrastructureMapper.map(trs);
    } catch (IOException e) {
      throw new InfrastructureException("Failed to http get %s".formatted(fullUrl), e);
    }
  }
}
