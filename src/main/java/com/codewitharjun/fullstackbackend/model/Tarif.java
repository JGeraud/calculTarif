package com.codewitharjun.fullstackbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tarif {

    @Id
    @GeneratedValue
    private Long id;

    private Long nomenclature;
    
    private String libelle;

    private Long pc;

    private Long pcs;

    private Long ps;

    private Long rs;

    private Long rau;

    private Long tst;

    private Long dd;

    private Long tva;

    private Long ddsh2022;

    private String codeUnite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Long nomenclature) {
        this.nomenclature = nomenclature;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Long getPc() {
        return pc;
    }

    public void setPc(Long pc) {
        this.pc = pc;
    }

    public Long getPcs() {
        return pcs;
    }

    public void setPcs(Long pcs) {
        this.pcs = pcs;
    }

    public Long getPs() {
        return ps;
    }

    public void setPs(Long ps) {
        this.ps = ps;
    }

    public Long getRs() {
        return rs;
    }

    public void setRs(Long rs) {
        this.rs = rs;
    }

    public Long getRau() {
        return rau;
    }

    public void setRau(Long rau) {
        this.rau = rau;
    }

    public Long getTst() {
        return tst;
    }

    public void setTst(Long tst) {
        this.tst = tst;
    }

    public Long getDd() {
        return dd;
    }

    public void setDd(Long dd) {
        this.dd = dd;
    }

    public Long getTva() {
        return tva;
    }

    public void setTva(Long tva) {
        this.tva = tva;
    }

    public Long getDdsh2022() {
        return ddsh2022;
    }

    public void setDdsh2022(Long ddsh2022) {
        this.ddsh2022 = ddsh2022;
    }

    public String getCodeUnite() {
        return codeUnite;
    }

    public void setCodeUnite(String codeUnite) {
        this.codeUnite = codeUnite;
    }
}
