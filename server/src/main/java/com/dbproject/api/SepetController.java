package com.dbproject.api;

import com.dbproject.api.model.Sepet;
import com.dbproject.api.repository.SepetRestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SepetController {
    private final SepetRestRepository repository;

    SepetController(SepetRestRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/sepet")
    List<Sepet> all() {
        return (List<Sepet>) repository.findAll();
    }

}