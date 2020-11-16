package com.dbproject.api.repository;

import com.dbproject.api.model.Bayilik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bayilik", path = "bayilik")
public interface BayilikRestRepository extends CrudRepository<Bayilik, Integer> {
}
