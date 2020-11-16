package com.dbproject.api;

import com.dbproject.api.model.AdresBayilik;
import com.dbproject.api.repository.AdresBayilikRestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdresBayilikController {
    private final AdresBayilikRestRepository repository;

    AdresBayilikController(AdresBayilikRestRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/adres_bayilik")
    List<AdresBayilik> all() {
        return (List<AdresBayilik>) repository.findAll();
    }
}
