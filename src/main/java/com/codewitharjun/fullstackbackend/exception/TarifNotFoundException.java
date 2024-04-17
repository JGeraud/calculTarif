package com.codewitharjun.fullstackbackend.exception;

public class TarifNotFoundException extends RuntimeException{

    public TarifNotFoundException(Integer nomenclature){
        super("Could not found the Tarif with nomenclature "+ nomenclature);
    }
}
