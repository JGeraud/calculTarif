package com.codewitharjun.fullstackbackend.model;

import javax.persistence.*;

@Entity
public class Tarifsw {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarif_generator")
    @SequenceGenerator(name = "tarif_generator", sequenceName = "tarif_sequence", allocationSize = 1, initialValue = 669)
    private Long id;

    private String nomenclature;

    private String libelle;

    private Double pc;

    private Double pcs;
     private Double ps;

    private Double rs;

    private Double rau;

    private Double tst;

    private Double dd_sw;



    private Double tva;

    private  Double ect;

  //  private Long aib;

    private Double da;

    private  Double caf ;

    private Double ttv;

    private Double tfs;

    private Double tsr;

    public Double getDd_sw() {
        return dd_sw;
    }

    public void setDd_sw(Double dd_sw) {
        this.dd_sw = dd_sw;
    }

    public Integer getDdSh2022() {
        return ddSh2022;
    }

    public void setDdSh2022(Integer ddSh2022) {
        this.ddSh2022 = ddSh2022;
    }

    private Integer ddSh2022;

    private String codeUnite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPc() {
        return pc;
    }

    public void setPc(Double pc) {
        this.pc = pc;
    }

    public Double getPcs() {
        return pcs;
    }

    public void setPcs(Double pcs) {
        this.pcs = pcs;
    }

    public Double getPs() {
        return ps;
    }

    public void setPs(Double ps) {
        this.ps = ps;
    }

    public Double getRs() {
        return rs;
    }

    public void setRs(Double rs) {
        this.rs = rs;
    }

    public Double getRau() {
        return rau;
    }

    public void setRau(Double rau) {
        this.rau = rau;
    }

    public Double getTst() {
        return tst;
    }

    public void setTst(Double tst) {
        this.tst = tst;
    }



    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    public Double getEct() {
        return ect;
    }

    public void setEct(Double ect) {
        this.ect = ect;
    }

   /* public Long getAib() {
        return aib;
    }

    public void setAib(Long aib) {
        this.aib = aib;
    }*/

    public Double getDa() {
        return da;
    }

    public void setDa(Double da) {
        this.da = da;
    }

    public Double getCaf() {
        return caf;
    }

    public void setCaf(Double caf) {
        this.caf = caf;
    }

    public Double getTtv() {
        return ttv;
    }

    public void setTtv(Double ttv) {
        this.ttv = ttv;
    }

    public Double getTfs() {
        return tfs;
    }

    public void setTfs(Double tfs) {
        this.tfs = tfs;
    }

    public Double getTsr() {
        return tsr;
    }

    public void setTsr(Double tsr) {
        this.tsr = tsr;
    }

   /* public Integer getDdsh2022() {
        return ddsh2022;
    }

    public void setDdsh2022(Integer ddsh2022) {
        this.ddsh2022 = ddsh2022;
    }*/

    public String getCodeUnite() {
        return codeUnite;
    }

    public void setCodeUnite(String codeUnite) {
        this.codeUnite = codeUnite;
    }
}
