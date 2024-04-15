package com.codewitharjun.fullstackbackend.controller;


import com.codewitharjun.fullstackbackend.exception.TarifNotFoundException;
import com.codewitharjun.fullstackbackend.model.Tarif;
import com.codewitharjun.fullstackbackend.repository.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class TarifController {



    @Autowired
    private TarifRepository tarifRepository;

    @PostMapping("/tarif")
    Tarif newTarif(@RequestBody Tarif newTarif) {
        return tarifRepository.save(newTarif);
    }

    @GetMapping("/tarifs")
    List<Tarif> getAllTarif() {
        return tarifRepository.findAll();
    }

   @GetMapping("/tarif/{nomenclature}")
   Object getTarifByNomenclature(@PathVariable Long nomenclature) {
        return tarifRepository.findByNomenclature(nomenclature)
                .orElseThrow(() -> new TarifNotFoundException(nomenclature));
    }

    @GetMapping("/tariflibelle/{Libellenomenclature}")
    String getLibelleByNomenclature(@PathVariable("Libellenomenclature") Long nomenclature) {
        Tarif tarif = (Tarif) tarifRepository.findByNomenclature(nomenclature)
                .orElseThrow(() -> new TarifNotFoundException(nomenclature));

        return tarif.getLibelle();
    }








}
