package com.DataProject.DataJPA.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DataProject.DataJPA.domain.Aeroporto;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long>{
	
	Optional<Aeroporto> findByIcao(String icao);
	Optional<Aeroporto> findByIata(String iata);
	Optional<List<Aeroporto>> findByCitta(String citta);
	
}
