package com.dbproject.api.repository;

import com.dbproject.api.model.Kart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "kart", path = "kart")
public interface KartRestRepository extends CrudRepository<Kart, Integer> {
}
