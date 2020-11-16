package com.dbproject.api.repository;

import com.dbproject.api.model.Kampanya;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "kampanya", path = "kampanya")
public interface KampanyaRestRepository extends CrudRepository<Kampanya, Integer> {
}
