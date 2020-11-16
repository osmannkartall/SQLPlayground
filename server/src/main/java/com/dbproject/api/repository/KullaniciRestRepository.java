package com.dbproject.api.repository;

import com.dbproject.api.model.Kullanici;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "kullanici", path = "kullanici")
public interface KullaniciRestRepository extends CrudRepository<Kullanici, Integer> {
}
