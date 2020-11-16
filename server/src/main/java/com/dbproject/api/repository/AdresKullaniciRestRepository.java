package com.dbproject.api.repository;

import com.dbproject.api.model.AdresKullanici;
import com.dbproject.api.model.AdresKullaniciId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "adres_kullanici", path = "adres_kullanici")
public interface AdresKullaniciRestRepository extends CrudRepository<AdresKullanici, AdresKullaniciId> {
}
