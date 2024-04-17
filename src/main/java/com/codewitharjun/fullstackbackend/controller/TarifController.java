package com.codewitharjun.fullstackbackend.controller;


import com.codewitharjun.fullstackbackend.exception.TarifNotFoundException;
import com.codewitharjun.fullstackbackend.model.Tarifsw;
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
    Tarifsw newTarif(@RequestBody Tarifsw newTarifsw) {
        return tarifRepository.save(newTarifsw);
    }

    @GetMapping("/tarifs")
    List<Tarifsw> getAllTarif() {
        return tarifRepository.findAll();
    }

   @GetMapping("/tarif/{nomenclature}")
   Object getTarifByNomenclature(@PathVariable Integer nomenclature) {
        return tarifRepository.findByNomenclature(nomenclature)
                .orElseThrow(() -> new TarifNotFoundException(nomenclature));
    }



    @GetMapping("/tariflibelle/{Libellenomenclature}")
    String getLibelleByNomenclature(@PathVariable("Libellenomenclature") Integer nomenclature) {
        Tarifsw tarifsw = (Tarifsw) tarifRepository.findByNomenclature(nomenclature)
                .orElseThrow(() -> new TarifNotFoundException(nomenclature));

        return tarifsw.getLibelle();
    }


    @GetMapping("/tarif/{nomenclature}/taux")
    double getTauxByNomenclature(@PathVariable Integer nomenclature) {
        Tarifsw tarifsw = (Tarifsw) tarifRepository.findByNomenclature(nomenclature)
                .orElseThrow(() -> new TarifNotFoundException(nomenclature));

        Double ps = tarifsw.getPs();
        Double pcs = tarifsw.getPcs();
        Double pc = tarifsw.getPc();
        Integer rs = tarifsw.getRs();
        Double rau = tarifsw.getRau();
        Double ect = tarifsw.getEct();
        Integer da = tarifsw.getDa();
        Long aib = tarifsw.getAib();
        Integer tva = tarifsw.getTva();

        if (ps == null || pcs == null || pc == null || rs == null || rau == null || ect == null || da == null || aib == null || tva == null) {
            throw new IllegalStateException("Une ou plusieurs valeur sont null");
        }

        // Calcul du taux
        double taux = ((pc+pcs+ps+rs+rau+ect)+(((pc+pcs+ps+rs+rau+ect)/100)*da)+(((pc+pcs+ps+rs+rau+ect+da)/100)*aib)+(((pc+pcs+ps+rs+rau+ect+da+aib)/100)*tva)) ;

        return taux;
    }








}
