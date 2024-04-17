package com.codewitharjun.fullstackbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tarif {

    @Id
    @GeneratedValue
    private Long id;

    private Integer nomenclature;

    private String libelle;

    private Double pc;

    private Double pcs;
     private Double ps;

    private Integer rs;

    private Double rau;

    private Double tst;

    private Integer dd;

    private Integer tva;

    private  Double ect;

    private Long aib;

    private Integer da;

    private  Integer caf ;

    private Integer ttv;

    private Integer tfs;

    private Integer tsr;




    private Integer ddsh2022;

    private String codeUnite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Integer nomenclature) {
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

    public Integer getRs() {
        return rs;
    }

    public void setRs(Integer rs) {
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

    public Integer getDd() {
        return dd;
    }

    public void setDd(Integer dd) {
        this.dd = dd;
    }

    public Integer getTva() {
        return tva;
    }

    public void setTva(Integer tva) {
        this.tva = tva;
    }

    public Double getEct() {
        return ect;
    }

    public void setEct(Double ect) {
        this.ect = ect;
    }

    public Long getAib() {
        return aib;
    }

    public void setAib(Long aib) {
        this.aib = aib;
    }

    public Integer getDa() {
        return da;
    }

    public void setDa(Integer da) {
        this.da = da;
    }

    public Integer getCaf() {
        return caf;
    }

    public void setCaf(Integer caf) {
        this.caf = caf;
    }

    public Integer getTtv() {
        return ttv;
    }

    public void setTtv(Integer ttv) {
        this.ttv = ttv;
    }

    public Integer getTfs() {
        return tfs;
    }

    public void setTfs(Integer tfs) {
        this.tfs = tfs;
    }

    public Integer getTsr() {
        return tsr;
    }

    public void setTsr(Integer tsr) {
        this.tsr = tsr;
    }

    public Integer getDdsh2022() {
        return ddsh2022;
    }

    public void setDdsh2022(Integer ddsh2022) {
        this.ddsh2022 = ddsh2022;
    }

    public String getCodeUnite() {
        return codeUnite;
    }

    public void setCodeUnite(String codeUnite) {
        this.codeUnite = codeUnite;
    }
}
