package com.dbproject.api.repository;

import com.dbproject.api.model.Duyuru;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "duyuru", path = "duyuru")
public interface DuyuruRestRepository extends CrudRepository<Duyuru, Integer> {
}
