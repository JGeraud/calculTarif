package com.codewitharjun.fullstackbackend.exception;

public class TarifNotFoundException extends RuntimeException{

    public TarifNotFoundException(Long nomenclature){
        super("Could not found the Tarif with nomenclature "+ nomenclature);
    }
}
