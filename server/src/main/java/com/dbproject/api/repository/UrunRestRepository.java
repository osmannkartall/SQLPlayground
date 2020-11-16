package com.dbproject.api.repository;

import com.dbproject.api.model.Urun;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "urun", path = "urun")
public interface UrunRestRepository extends CrudRepository<Urun, Integer> {
}
