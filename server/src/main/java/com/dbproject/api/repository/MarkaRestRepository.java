package com.dbproject.api.repository;

import com.dbproject.api.model.Marka;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "marka", path = "marka")
public interface MarkaRestRepository extends CrudRepository<Marka, Integer> {
}
