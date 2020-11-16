package com.dbproject.api.repository;

import com.dbproject.api.model.Kategori;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "kategori", path = "kategori")
public interface KategoriRestRepository extends CrudRepository<Kategori, Integer> {
}
