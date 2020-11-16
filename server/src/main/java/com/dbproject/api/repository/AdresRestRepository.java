package com.dbproject.api.repository;

import com.dbproject.api.model.Adres;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "adres", path = "adres")
public interface AdresRestRepository extends CrudRepository<Adres, Integer> {
}
