package com.dbproject.api.repository;

import com.dbproject.api.model.AltKategori;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "alt_kategori", path = "alt_kategori")
public interface AltKategoriRestRepository extends CrudRepository<AltKategori, Integer> {
}
