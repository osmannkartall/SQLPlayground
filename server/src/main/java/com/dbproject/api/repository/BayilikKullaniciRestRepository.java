package com.dbproject.api.repository;

import com.dbproject.api.model.BayilikKullanici;
import com.dbproject.api.model.BayilikKullaniciId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bayilik_kullanici", path = "bayilik_kullanici")
public interface BayilikKullaniciRestRepository extends CrudRepository<BayilikKullanici, BayilikKullaniciId> {
}
