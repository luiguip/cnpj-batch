package com.github.luiguip.cnpj_batch.infrastructure.adapter;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.github.luiguip.cnpj_batch.domain.CnpjDataFolderObjectMother;
import com.github.luiguip.cnpj_batch.domain.InfrastructureException;
import com.github.luiguip.cnpj_batch.infrastructure.mapper.CnpjDataInfrastructureMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@WireMockTest
@ExtendWith(MockitoExtension.class)
class JsoupServiceTest {

  private JsoupService jsoupService;

  @Spy
  private CnpjDataInfrastructureMapper cnpjDataInfrastructureMapper;

  @BeforeEach
  void setUp(WireMockRuntimeInfo wireMockRuntimeInfo) {
    jsoupService = new JsoupService(cnpjDataInfrastructureMapper,
        wireMockRuntimeInfo.getHttpBaseUrl());
  }

  @Test
  void givenValidUrl_whenFindCnpjDataFolders_thenReturnCnpjDataFolder() {
    //given
    var expected = CnpjDataFolderObjectMother.createList();
    stubFor(
        get(JsoupService.FOLDER_PATH)
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "text/html")
                .withBodyFile(
                    "dados/cnpj/dados_abertos_cnpj/initial_page.html")
            )
    );

    //when
    var actual = jsoupService.findCnpjDataFolders();

    //then
    assertThat(actual)
        .hasSameElementsAs(expected)
        .hasSize(expected.size());
    verify(getRequestedFor(urlEqualTo(JsoupService.FOLDER_PATH)));
  }

  @Test
  void givenInvalidUrl_whenFindCnpjDataFoldersNotFound_thenThrowNotFoundException() {
    //given
    stubFor(
        get(JsoupService.FOLDER_PATH)
            .willReturn(aResponse()
                .withStatus(404)
                .withHeader("Content-Type", "text/html")
                .withBodyFile(
                    "dados/cnpj/dados_abertos_cnpj/not_found.html")
            )
    );

    //when
    ThrowingCallable callable = () -> jsoupService.findCnpjDataFolders();

    //then
    assertThatThrownBy(callable)
        .isInstanceOf(InfrastructureException.class);
    verify(getRequestedFor(urlEqualTo(JsoupService.FOLDER_PATH)));
  }

  @Test
  void givenInvalidUrl_whenFindCnpjDataFoldersInternalServerError_thenThrowNotFoundException() {
    //given
    stubFor(
        get(JsoupService.FOLDER_PATH)
            .willReturn(aResponse()
                .withStatus(500)
                .withHeader("Content-Type", "text/html")
                .withBodyFile(
                    "dados/cnpj/dados_abertos_cnpj/not_found.html")
            )
    );

    //when
    ThrowingCallable callable = () -> jsoupService.findCnpjDataFolders();

    //then
    assertThatThrownBy(callable)
        .isInstanceOf(InfrastructureException.class);
    verify(getRequestedFor(urlEqualTo(JsoupService.FOLDER_PATH)));
  }
}