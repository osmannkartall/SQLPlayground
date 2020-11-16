package com.dbproject.api.repository;

import com.dbproject.api.model.Stok;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "stok", path = "stok")
public interface StokRestRepository extends CrudRepository<Stok, Integer> {
}
