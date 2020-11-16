package com.dbproject.api;

import com.dbproject.api.model.AdresKullanici;
import com.dbproject.api.repository.AdresKullaniciRestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AdresKullaniciController {
    private final AdresKullaniciRestRepository repository;

    AdresKullaniciController(AdresKullaniciRestRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/adres_kullanici")
    List<AdresKullanici> all() {
        return (List<AdresKullanici>) repository.findAll();
    }
}
