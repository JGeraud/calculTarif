package com.codewitharjun.fullstackbackend.exception;

import java.math.BigInteger;

public class TarifNotFoundException extends RuntimeException{

    public TarifNotFoundException(Integer nomenclature){
        super("Could not found the Tarif with nomenclature "+ nomenclature);
    }
}
