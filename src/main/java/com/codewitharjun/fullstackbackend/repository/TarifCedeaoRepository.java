package com.codewitharjun.fullstackbackend.repository;

import com.codewitharjun.fullstackbackend.model.Tarifsw;
 import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TarifCedeaoRepository extends JpaRepository<Tarifsw,String> {
    Optional<Object> findByNomenclature(String nomenclature);

    Optional<Object> getTauxLineaireByNomenclature(String nomenclature);

}
