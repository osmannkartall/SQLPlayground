package com.dbproject.api;

import com.dbproject.api.model.BayilikKullanici;
import com.dbproject.api.repository.BayilikKullaniciRestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BayilikKullaniciController {
    private final BayilikKullaniciRestRepository repository;

    BayilikKullaniciController(BayilikKullaniciRestRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/bayilik_kullanici")
    List<BayilikKullanici> all() {
        return (List<BayilikKullanici>) repository.findAll();
    }
}
