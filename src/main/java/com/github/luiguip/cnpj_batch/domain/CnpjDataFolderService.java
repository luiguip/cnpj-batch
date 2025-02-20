package com.github.luiguip.cnpj_batch.domain;

import com.github.luiguip.cnpj_batch.infrastructure.client.RfCnpjClient;
import com.github.luiguip.cnpj_batch.infrastructure.repository.CnpjDataFolderRepository;
import org.springframework.stereotype.Service;

@Service
public class CnpjDataFolderService {

  private final RfCnpjClient rfCnpjClient;
  private final CnpjDataFolderRepository cnpjDataFolderRepository;

  public CnpjDataFolderService(RfCnpjClient rfCnpjClient,
      CnpjDataFolderRepository cnpjDataFolderRepository) {
    this.rfCnpjClient = rfCnpjClient;
    this.cnpjDataFolderRepository = cnpjDataFolderRepository;
  }

  public void retrieveCnpjDataFolders() {
    var cnpjDataFolders = rfCnpjClient.findCnpjDataFolders();
  }
}
