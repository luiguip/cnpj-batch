package com.github.luiguip.cnpj_batch.configuration;

public class IntegrationConfigurationPropertiesFixture {

  public static IntegrationConfigurationProperties create(String url) {
    return new IntegrationConfigurationProperties(
        url, "/path/"
    );
  }
}