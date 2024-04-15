package com.codewitharjun.fullstackbackend.repository;

import com.codewitharjun.fullstackbackend.model.Tarif;
 import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TarifRepository extends JpaRepository<Tarif,Long> {
 Optional<Object> findByNomenclature(Long nomenclature);
}
