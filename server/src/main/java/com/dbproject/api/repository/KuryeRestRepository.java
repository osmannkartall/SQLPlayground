package com.dbproject.api.repository;

import com.dbproject.api.model.Kurye;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "kurye", path = "kurye")
public interface KuryeRestRepository extends CrudRepository<Kurye, Integer> {
}
