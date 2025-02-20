package com.github.luiguip.cnpj_batch.configuration;

public class IntegrationConfigurationPropertiesFixture {

  public static IntegrationConfigurationProperties create(String url) {
    var integrationConfigurationProperties = new IntegrationConfigurationProperties();
    integrationConfigurationProperties.setRfCnpjUrl(url);
    integrationConfigurationProperties.setRfCnpjFolderPath("/path/");
    return integrationConfigurationProperties;
  }
}