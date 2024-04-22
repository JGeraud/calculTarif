package com.codewitharjun.fullstackbackend.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.codewitharjun.fullstackbackend.exception.TarifNotFoundException;
import com.codewitharjun.fullstackbackend.model.Tarifsw;
import com.codewitharjun.fullstackbackend.repository.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TarifController {



    @Autowired
    private TarifRepository tarifRepository;

    @PostMapping("/api/tarif")
    Tarifsw newTarif(@RequestBody Tarifsw newTarifsw) {
        return tarifRepository.save(newTarifsw);
    }

    @GetMapping("/api/tarifs")
    List<Tarifsw> getAllTarif() {
        return tarifRepository.findAll();
    }

   @GetMapping("/api/tarif/{nomenclature}")
   Object getTarifByNomenclature(@PathVariable Integer nomenclature) {
        return tarifRepository.findByNomenclature(nomenclature)
                .orElseThrow(() -> new TarifNotFoundException(nomenclature));
    }


    class tarifsw {
        String libelle ;

        public tarifsw(String libelle) {
            this.libelle = libelle;
        }

        public String getLibelle() {
            return libelle;
        }

        public void setLibelle(String libelle) {
            this.libelle = libelle;
        }
    }
    @GetMapping("/api/tariflibelle/{Libellenomenclature}")
    Object getLibelleByNomenclature(@PathVariable("Libellenomenclature") Integer nomenclature) {
        Tarifsw tarifsw = (Tarifsw) tarifRepository.findByNomenclature(nomenclature)
                .orElseThrow(() -> new TarifNotFoundException(nomenclature));
        System.out.println("le libeller voulu  est " + tarifsw.getLibelle());
        return new tarifsw(tarifsw.getLibelle());
    }


    @GetMapping("/api/tarif/{nomenclature}/taux")
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
        Integer dd = tarifsw.getDd_sw();
       // Long aib = tarifsw.getAib();
        Integer tva = tarifsw.getTva();

        if (ps == null || pcs == null || pc == null || rs == null || rau == null || ect == null || da == null || tva == null) {
            throw new IllegalStateException("Une ou plusieurs valeur sont null");
        }
        double tauxda = ((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da);
        double tauxaid = ((((pc+pcs+ps+dd+rs+rau+ect) +(((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da))+100)/100)*1);
        double tauxtva =   ((((pc+pcs+ps+dd+rs+rau) + (((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da))+100)/100)*tva);

        System.out.println("le taux da est " + tauxda );
        System.out.println("le taux aib est " + tauxaid );
        System.out.println("le taux tva est " + tauxtva );

        // Calcul du taux
         double taux = (pc+pcs+ps+rs+dd+rau+ect)+
                 ((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da)+
                 ((((pc+pcs+ps+dd+rs+rau+ect+ (((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da)))+100)/100)*1)+
                 ((((pc+pcs+ps+dd+rs+rau) + (((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da))+100)/100)*tva);


        return  taux;
    }








}
