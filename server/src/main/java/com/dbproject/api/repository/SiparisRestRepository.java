package com.dbproject.api.repository;

import com.dbproject.api.model.Siparis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "siparis", path = "siparis")
public interface SiparisRestRepository extends CrudRepository<Siparis, Integer> {
}
