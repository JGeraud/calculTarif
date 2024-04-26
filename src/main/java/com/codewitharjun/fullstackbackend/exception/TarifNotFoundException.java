package com.codewitharjun.fullstackbackend.exception;

public class TarifNotFoundException extends RuntimeException{

    public TarifNotFoundException(String nomenclature){
        super("Could not found the Tarif with nomenclature "+ nomenclature);
    }
}
