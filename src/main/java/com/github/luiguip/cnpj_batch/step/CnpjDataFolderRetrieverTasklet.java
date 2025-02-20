package com.github.luiguip.cnpj_batch.step;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class CnpjDataFolderRetrieverTasklet implements Tasklet, InitializingBean {

  @Value("${integration.index-page-path}")
  private String indexPagePath;

  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws Exception {
    return null;
  }

  @Override
  public void afterPropertiesSet() {
    Assert.state(StringUtils.hasText(indexPagePath), "indexPage must not be empty");
  }
}
