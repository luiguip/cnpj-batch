package com.github.luiguip.cnpj_batch.infrastructure.repository;

import com.github.luiguip.cnpj_batch.domain.CnpjDataFolderFixture;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class CnpjDataFolderRepositoryTest {

  static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
      "postgres:16-alpine"
  );

  @Autowired
  private CnpjDataFolderRepository cnpjDataFolderRepository;

  @BeforeAll
  static void beforeAll() {
    postgres.start();
  }

  @AfterAll
  static void afterAll() {
    postgres.stop();
  }

  @DynamicPropertySource
  static void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgres::getJdbcUrl);
    registry.add("spring.datasource.username", postgres::getUsername);
    registry.add("spring.datasource.password", postgres::getPassword);
  }

  @Test
  void givenEmptyDatabase_WhenFindAll_thenReturnEmptyList() {
    //given
    //when
    var actual = cnpjDataFolderRepository.findAll();
    //then
    Assertions.assertThat(actual).isEmpty();
  }

  @Test
  @Sql("/datasets/cnpj_data_folder.sql")
  @Sql(value = "/datasets/clean.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
  void givenPopulatedDatabase_WhenFindAll_thenReturnAllEntities() {
    //given
    var expected = CnpjDataFolderFixture.createList();
    //when
    var actual = cnpjDataFolderRepository.findAll();
    //then
    Assertions.assertThat(actual).hasSameElementsAs(expected).hasSameSizeAs(expected);
  }

  @Test
  @Sql(value = "/datasets/clean.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
  void givenEmptyDatabase_WhenSave_thenReturnSavedEntity() {
    //given
    var expected = CnpjDataFolderFixture.create();
    //when
    var actual = cnpjDataFolderRepository.save(expected);
    var all = cnpjDataFolderRepository.findAll();
    //then
    Assertions.assertThat(actual).isEqualTo(expected);
    Assertions.assertThat(all).hasSize(1).hasSameElementsAs(List.of(actual));
  }
}