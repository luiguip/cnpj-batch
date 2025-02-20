package com.github.luiguip.cnpj_batch.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "integration")
public class IntegrationConfigurationProperties {

  private String rfCnpjUrl;
  private String rfCnpjFolderPath;

  public String getRfCnpjUrl() {
    return rfCnpjUrl;
  }

  public void setRfCnpjUrl(String rfCnpjUrl) {
    this.rfCnpjUrl = rfCnpjUrl;
  }

  public String getRfCnpjFolderPath() {
    return rfCnpjFolderPath;
  }

  public void setRfCnpjFolderPath(String rfCnpjFolderPath) {
    this.rfCnpjFolderPath = rfCnpjFolderPath;
  }
}
