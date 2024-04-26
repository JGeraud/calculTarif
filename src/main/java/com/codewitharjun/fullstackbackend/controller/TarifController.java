package com.codewitharjun.fullstackbackend.controller;


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

    @GetMapping("/api")
    List<Tarifsw> getAllTarif() {
        return tarifRepository.findAll();
    }

   @GetMapping("/api/tarif/{nomenclature}")
   Object getTarifByNomenclature(@PathVariable String nomenclature) {
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

    class  tarifswtaux{

        double taux;

        double tauxda, tauxaib, tauxtva, tauxrs, tauxpc,tauxpcs,tauxps,tauxrau,tauxect,tauxdd;



        public tarifswtaux(double taux, double tauxaid, double tauxda, double tauxtva, double tauxrs, double tauxps, double tauxpcs, double tauxrau, double tauxect, double tauxdd, double v) {
            this.taux =taux;
            this.tauxaib=tauxaid;
            this.tauxda = tauxda;
            this.tauxtva=tauxtva;
            this.tauxrs=tauxrs;
            this.tauxps=tauxps;
            this.tauxpc=tauxpcs;
            this.tauxrau=tauxrau;
            this.tauxect=tauxect;
            this.tauxdd=tauxdd;

        }
        public double getTauxdd() {
            return tauxdd;
        }

        public void setTauxdd(double tauxdd) {
            this.tauxrs = tauxdd;
        }

        public double getTauxrs() {
            return tauxrs;
        }

        public void setTauxrs(double tauxrs) {
            this.tauxrs = tauxrs;
        }

        public double getTauxpc() {
            return tauxpc;
        }

        public void setTauxpc(double tauxpc) {
            this.tauxpc = tauxpc;
        }

        public double getTauxpcs() {
            return tauxpcs;
        }

        public void setTauxpcs(double tauxpcs) {
            this.tauxpcs = tauxpcs;
        }

        public double getTauxps() {
            return tauxps;
        }

        public void setTauxps(double tauxps) {
            this.tauxps = tauxps;
        }

        public double getTauxrau() {
            return tauxrau;
        }

        public void setTauxrau(double tauxrau) {
            this.tauxrau = tauxrau;
        }

        public double getTauxect() {
            return tauxect;
        }

        public void setTauxect(double tauxect) {
            this.tauxect = tauxect;
        }

        public double getTauxda() {
            return tauxda;
        }

        public void setTauxda(double tauxda) {
            this.tauxda = tauxda;
        }

        public double getTauxaib() {
            return tauxaib;
        }

        public void setTauxaib(double tauxaib) {
            this.tauxaib = tauxaib;
        }

        public double getTauxtva() {
            return tauxtva;
        }

        public void setTauxtva(double tauxtva) {
            this.tauxtva = tauxtva;
        }


        public double getTaux() {
            return taux;
        }

        public void setTaux(double taux) {
            this.taux = taux;
        }


    }
    @GetMapping("/api/tariflibelle/{Libellenomenclature}")
    Object getLibelleByNomenclature(@PathVariable("Libellenomenclature") String nomenclature) {
        Tarifsw tarifsw = (Tarifsw) tarifRepository.findByNomenclature(nomenclature)
                .orElseThrow(() -> new TarifNotFoundException(nomenclature));
        System.out.println("le libeller voulu  est " + tarifsw.getLibelle());
        return new tarifsw(tarifsw.getLibelle());
    }




    //calcul du taux



    @GetMapping("/api/tarif/taux/{nomenclature}")
    tarifswtaux getTauxByNomenclature(@PathVariable String nomenclature) {
        Tarifsw tarifsw = (Tarifsw) tarifRepository.findByNomenclature(nomenclature)
                .orElseThrow(() -> new TarifNotFoundException(nomenclature));

        Double ps = tarifsw.getPs();
        Double pcs = tarifsw.getPcs();
        Double pc = tarifsw.getPc();
        Double rs = tarifsw.getRs();
        Double rau = tarifsw.getRau();
        Double ect = tarifsw.getEct();
        Double da = tarifsw.getDa();
        Double dd = tarifsw.getDd_sw();
       // Long aib = tarifsw.getAib();
        Double tva = tarifsw.getTva();

        if (ps == null || pcs == null || pc == null || rs == null || rau == null || ect == null || da == null || tva == null) {
            throw new IllegalStateException("Une ou plusieurs valeur sont null");
        }
        double tauxda = ((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da);
        double tauxaid = ((((pc+pcs+ps+dd+rs+rau+ect) +(((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da))+100)/100)*1);
        double tauxtva =   ((((pc+pcs+ps+dd+rs+rau) + (((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da))+100)/100)*tva);

        System.out.println("le taux da est " + tauxda );
        System.out.println("le taux aib est " + tauxaid );
        System.out.println("le taux tva est " + tauxtva );

        double tauxps = tarifsw.getPs();
        double tauxpcs = tarifsw.getPcs();
        double tauxpc = tarifsw.getPc();
        double tauxrs = tarifsw.getRs();
        double tauxrau = tarifsw.getRau();
        double tauxect = tarifsw.getEct();
        double tauxdd = tarifsw.getDd_sw();


        // Calcul du taux
         double taux = (pc+pcs+ps+rs+dd+rau+ect)+
                 ((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da)+
                 ((((pc+pcs+ps+dd+rs+rau+ect+ (((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da)))+100)/100)*1)+
                 ((((pc+pcs+ps+dd+rs+rau) + (((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da))+100)/100)*tva);

         return new tarifswtaux(taux,tauxaid,tauxda,tauxtva, tauxrs, tauxps, tauxrau, tauxpc, tauxect, tauxpcs, tauxdd);
    }








}
