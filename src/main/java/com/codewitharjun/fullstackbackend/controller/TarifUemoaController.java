package com.codewitharjun.fullstackbackend.controller;

import com.codewitharjun.fullstackbackend.exception.TarifNotFoundException;
import com.codewitharjun.fullstackbackend.model.Tarifsw;
import com.codewitharjun.fullstackbackend.repository.TarifUemoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class TarifUemoaController {



    @Autowired
    private TarifUemoaRepository tarifUemoaRepository;


    class tarifsw {
        String libelle ;
        Double ps, pcs, pc, rs, rau, ect, dd, da, tva, aib;


        public tarifsw(String libelle) {
            this.libelle = libelle;
        }

        public Double getPs() {
            return ps;
        }

        public void setPs(Double ps) {
            this.ps = ps;
        }

        public Double getPcs() {
            return pcs;
        }

        public Double getRau() {
            return rau;
        }

        public void setRau(Double rau) {
            this.rau = rau;
        }

        public Double getEct() {
            return ect;
        }

        public void setEct(Double ect) {
            this.ect = ect;
        }

        public Double getDd() {
            return dd;
        }

        public void setDd(Double dd) {
            this.dd = dd;
        }

        public Double getDa() {
            return da;
        }

        public void setDa(Double da) {
            this.da = da;
        }

        public Double getTva() {
            return tva;
        }

        public void setTva(Double tva) {
            this.tva = tva;
        }

        public Double getAib() {
            return aib;
        }

        public void setAib(Double aib) {
            this.aib = aib;
        }

        public void setPcs(Double pcs) {
            this.pcs = pcs;
        }

        public Double getPc() {
            return pc;
        }

        public void setPc(Double pc) {
            this.pc = pc;
        }

        public Double getRs() {
            return rs;
        }

        public void setRs(Double rs) {
            this.rs = rs;
        }

        public tarifsw(Double ps, Double pcs, Double pc, Double rs, Double rau, Double ect, Double dd, Double da, Double tva) {
            this.ps=ps;this.pcs=pcs;this.pc=pc;this.rs=rs;this.rau=rau;this.ect=ect;this.dd=dd;this.da=da;this.tva=tva;


        }

        public String getLibelle() {
            return libelle;
        }

        public void setLibelle(String libelle) {
            this.libelle = libelle;
        }
    }

    class  tarifswtaux {

        double taux;
        int counter;
        double tauxda, tauxaib, tauxtva, tauxrs, tauxpc,tauxpcs,tauxps,tauxrau,tauxect,tauxdd;



        public tarifswtaux(int counter, double taux, double tauxaid, double tauxda, double tauxtva, double tauxrs, double tauxps, double tauxpcs, double tauxrau,double tauxpc, double tauxect, double tauxdd) {
            this.counter=counter;
            this.taux =taux;
            this.tauxaib=tauxaid;
            this.tauxda = tauxda;
            this.tauxtva=tauxtva;
            this.tauxrs=tauxrs;
            this.tauxps=tauxps;
            this.tauxpcs=tauxpcs;
            this.tauxrau=tauxrau;
            this.tauxpc=tauxpc;
            this.tauxect=tauxect;
            this.tauxdd=tauxdd;

        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
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
    public class CalculResult {
        private String nomenclature;
        private double taux;

        public CalculResult(String nomenclature, double taux) {
            this.nomenclature = nomenclature;
            this.taux = taux;
        }

        // Getters et setters

        public String getNomenclature() {
            return nomenclature;
        }

        public void setNomenclature(String nomenclature) {
            this.nomenclature = nomenclature;
        }

        public double getTaux() {
            return taux;
        }

        public void setTaux(double taux) {
            this.taux = taux;
        }
    }
    private List<CalculResult> historiqueCalculs = new ArrayList<>();
    @GetMapping("/api/tariflibelletarifUemoa/{Libellenomenclature}")
    Map<String, Object> getLibelleByNomenclatureUemoa(@PathVariable("Libellenomenclature") String nomenclature) {
        Tarifsw tarifsw = (Tarifsw) tarifUemoaRepository.findByNomenclature(nomenclature)
                .orElseThrow(() -> new TarifNotFoundException(nomenclature));
        System.out.println("Le libellé voulu est : " + tarifsw.getLibelle());

        if (nomenclature.equals("8703231100") || nomenclature.equals("8703231900") || nomenclature.equals("8703232000")
                || nomenclature.equals("8703241100") || nomenclature.equals("8703241900") || nomenclature.equals("8703242000")) {
            Map<String, Object> result = new HashMap<>();
            result.put("nomenclature", nomenclature);
            result.put("libelle", tarifsw.getLibelle());
            result.put("statut", "OK"); // Ajout du statut OK
            return result;
        } else {
            Map<String, Object> result = new HashMap<>();
            result.put("libelle", tarifsw.getLibelle());
            result.put("statut", "NOK"); // Ajout du statut NOK
            return result;
        }
    }
    private String getStatutByNomenclature(String nomenclature) {
        Map<String, Object> response = getLibelleByNomenclatureUemoa(nomenclature);
        return (String) response.get("statut");
    }

    // recuper la valeur du checkbox
    @PostMapping("/api/tarifUemoa/checkbox")
    public ResponseEntity<String> receiveCheckboxState(@RequestBody Map<String, Boolean> checkboxState) {
        Boolean isChecked = checkboxState.get("isChecked");

        if (isChecked) {
            // Le checkbox est coché
            // Effectuer les actions nécessaires
            return ResponseEntity.ok("Checkbox coché");
        } else {
            // Le checkbox n'est pas coché
            // Effectuer les actions nécessaires
            return ResponseEntity.ok("Checkbox non coché");
        }
    }
    private int counter = 0;

    @GetMapping("/api/tarifUemoa/taux/{nomenclature}")
    tarifswtaux getTauxCedeaoByNomenclature(@PathVariable String nomenclature, @RequestParam(required = false) int isChecked) {
        Tarifsw tarifsw = (Tarifsw) tarifUemoaRepository.findByNomenclature(nomenclature)
                .orElseThrow(() -> new TarifNotFoundException(nomenclature));

        counter++;

        Double ps = 0.0;
        Double pcs = 0.0;
        Double pc = 0.0;
        Double rs = 0.0;
        Double rau = tarifsw.getRau();
        Double ect = tarifsw.getEct();
        Double da = tarifsw.getDa();
        Double dd = 0.0;
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

        double tauxps = 0.0;
        double tauxpcs = 0.0;
        double tauxpc = 0.0;
        double tauxrs = 0.0;
        double tauxrau = tarifsw.getRau();
        double tauxect = tarifsw.getEct();
        double tauxdd = 0.0;
        String statut = getStatutByNomenclature(nomenclature);
        System.out.println("Le statut est." + statut);


        double taux;
        taux = (pc+pcs+ps+rs+dd+rau+ect)+
                ((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da)+
                ((((pc+pcs+ps+dd+rs+rau+ect+ (((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da)))+100)/100)*1)+
                ((((pc+pcs+ps+dd+rs+rau) + (((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da))+100)/100)*tva);

        if (statut.equals("OK") && isChecked == 1)
        {

            System.out.println("Le statut  statut est." + statut);
            taux = (pc+pcs+ps+rs+dd+rau+ect)+
                    ((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da)+
                    ((((pc+pcs+ps+dd+rs+rau+ect+ (((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da)))+100)/100)*10)+
                    ((((pc+pcs+ps+dd+rs+rau) + (((((pc+pcs+ps+dd+rs+rau+ect)+100)/100)*da))+100)/100)*tva);



        }
        historiqueCalculs.add(new CalculResult(nomenclature, taux));
        return new TarifUemoaController.tarifswtaux(counter,taux,tauxaid,tauxda,tauxtva, tauxrs, tauxps,tauxpcs, tauxrau, tauxpc, tauxect,tauxdd);
    }

    //Recuperation de l'historique
    @GetMapping("/api/tarifUemoa/historique")
    public List<CalculResult> getHistoriqueCalculs() {
        return historiqueCalculs;
    }


    //Recuperation des taux lineaire


    @GetMapping("/api/tarifUemoa/tauxlineaire/{nomenclature}")
    tarifsw getTauxLineaireCedeaoByNomenclature(@PathVariable String nomenclature) {
        Tarifsw tarifsw = (Tarifsw) tarifUemoaRepository.findByNomenclature(nomenclature)
                .orElseThrow(() -> new TarifNotFoundException(nomenclature));

        counter++;

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



        // Calcul du taux

        return new TarifUemoaController.tarifsw(ps, pcs, pc, rs, rau, ect,dd,da,tva);
    }


}
