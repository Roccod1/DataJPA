package com.DataProject.DataJPA.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.DataProject.DataJPA.domain.Aeroporto;
import com.DataProject.DataJPA.repository.AeroportoRepository;
import com.DataProject.DataJPA.service.AeroportoService;


@Service
public class AeroportoServiceImpl implements AeroportoService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private final AeroportoRepository aeroportoRepository;
	
	
	public AeroportoServiceImpl(AeroportoRepository aeroportoRepository) {
		this.aeroportoRepository=aeroportoRepository;
	}

	@Override
	public Optional<Aeroporto> getAeroportoByIcao(String icao) {
		logger.debug("Init getAeroportoByIcao");
		Optional<Aeroporto> optionalAeroporto = aeroportoRepository.findByIcao(icao);
		if(optionalAeroporto.isPresent()) {
			logger.debug("found ByIcao with icao {}: {}", icao, optionalAeroporto.get());
		}
		return optionalAeroporto;
	}

	@Override
	public Optional<Aeroporto> getAeroportoByIata(String iata) {
		logger.debug("Init getAeroportoByIata");
		Optional<Aeroporto> optionalAeroporto = aeroportoRepository.findByIata(iata);
		if(optionalAeroporto.isPresent()) {
			logger.debug("found ByIata with iata {}: {}", iata, optionalAeroporto.get());
		}
		return optionalAeroporto;
	}

	@Override
	public Optional<List<Aeroporto>> getAeroportoByCitta(String citta) {
		logger.debug("Init getAeroportoByCitta");
		Optional<List<Aeroporto>> optionalAeroporto = aeroportoRepository.findByCitta(citta);
		if(optionalAeroporto.isPresent()) {
			logger.debug("found ByIata with iata {}: {}", citta, optionalAeroporto.get());
		}
		return optionalAeroporto;
	}

}
