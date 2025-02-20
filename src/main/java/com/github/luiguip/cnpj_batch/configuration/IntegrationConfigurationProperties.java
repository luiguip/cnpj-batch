package com.github.luiguip.cnpj_batch.configuration;

import org.springframework.context.annotation.PropertySource;

@PropertySource("integration")
public record IntegrationConfigurationProperties(
    String rfCnpjUrl,
    String rfCnpjFolderPath
) {

}
