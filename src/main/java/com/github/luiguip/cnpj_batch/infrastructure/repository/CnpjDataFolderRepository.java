package com.github.luiguip.cnpj_batch.infrastructure.repository;

import com.github.luiguip.cnpj_batch.domain.CnpjDataFolder;
import com.github.luiguip.cnpj_batch.infrastructure.repository.entity.CnpjDataFolderEntity;
import com.github.luiguip.cnpj_batch.infrastructure.mapper.CnpjDataInfrastructureMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CnpjDataFolderRepository {

  private final EntityManager entityManager;
  private final CnpjDataInfrastructureMapper mapper;

  public CnpjDataFolderRepository(EntityManager entityManager,
      CnpjDataInfrastructureMapper mapper) {
    this.entityManager = entityManager;
    this.mapper = mapper;
  }

  public List<CnpjDataFolder> findAll() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<CnpjDataFolderEntity> cq = cb.createQuery(CnpjDataFolderEntity.class);
    Root<CnpjDataFolderEntity> rootEntry = cq.from(CnpjDataFolderEntity.class);
    CriteriaQuery<CnpjDataFolderEntity> all = cq.select(rootEntry);

    TypedQuery<CnpjDataFolderEntity> allQuery = entityManager.createQuery(all);
    List<CnpjDataFolderEntity> entities = allQuery.getResultList();
    return mapper.map(entities);
  }

  @Transactional
  public CnpjDataFolder save(CnpjDataFolder cnpjDataFolder) {
    var entity = mapper.map(cnpjDataFolder);
    if(entity.getId() != null) {
      var retrievedEntity = entityManager.find(CnpjDataFolderEntity.class, entity.getId());
      mapper.map(retrievedEntity, entity);
    } else {
      entityManager.persist(entity);
    }
    return mapper.map(entity);
  }
}
