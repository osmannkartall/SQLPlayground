package com.dbproject.api.repository;

import com.dbproject.api.model.AdresBayilik;
import com.dbproject.api.model.AdresBayilikId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "adres_bayilik", path = "adres_bayilik")
public interface AdresBayilikRestRepository extends CrudRepository<AdresBayilik, AdresBayilikId> {
}
