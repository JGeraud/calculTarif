package com.codewitharjun.fullstackbackend.dto;

public class TarifswtauxDTO {
    private int counter;
    private double taux;
    private double tauxaid;
    private double tauxda;
    private double tauxtva;
    private double tauxrs;
    private double tauxps;
    private double tauxpcs;
    private double tauxrau;
    private double tauxpc;
    private double tauxect;
    private double tauxdd;

    public TarifswtauxDTO(int counter, double taux, double tauxaid, double tauxda, double tauxtva, double tauxrs, double tauxps, double tauxpcs, double tauxrau, double tauxpc, double tauxect, double tauxdd) {
        this.counter = counter;
        this.taux = taux;
        this.tauxaid = tauxaid;
        this.tauxda = tauxda;
        this.tauxtva = tauxtva;
        this.tauxrs = tauxrs;
        this.tauxps = tauxps;
        this.tauxpcs = tauxpcs;
        this.tauxrau = tauxrau;
        this.tauxpc = tauxpc;
        this.tauxect = tauxect;
        this.tauxdd = tauxdd;
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

    public double getTauxaid() {
        return tauxaid;
    }

    public void setTauxaid(double tauxaid) {
        this.tauxaid = tauxaid;
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