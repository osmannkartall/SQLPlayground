package com.dbproject.api.repository;

import com.dbproject.api.model.Sepet;
import com.dbproject.api.model.SepetId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sepet", path = "sepet")
public interface SepetRestRepository extends CrudRepository<Sepet, SepetId> {
}
