package com.DataProject.DataJPA.service;

import java.util.List;
import java.util.Optional;

import com.DataProject.DataJPA.domain.Aeroporto;


public interface AeroportoService {
	
	Optional<Aeroporto> getAeroportoByIcao(String icao);
	Optional<Aeroporto> getAeroportoByIata(String iata);
	Optional<List<Aeroporto>> getAeroportoByCitta(String citta);

}
