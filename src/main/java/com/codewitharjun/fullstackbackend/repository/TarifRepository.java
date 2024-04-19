package com.codewitharjun.fullstackbackend.repository;

import com.codewitharjun.fullstackbackend.model.Tarifsw;
 import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface TarifRepository extends JpaRepository<Tarifsw, Integer> {
 Optional<Object> findByNomenclature(Integer nomenclature);
}
