package com.DataProject.DataJPA.service.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DataProject.DataJPA.domain.Paese;
import com.DataProject.DataJPA.repository.PaeseRepository;
import com.DataProject.DataJPA.service.PaeseService;
import com.DataProject.DataJPA.service.dto.PaeseDTO;
import com.DataProject.DataJPA.service.mapper.PaeseMapper;


@Service
public class PaeseServiceImpl implements PaeseService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private PaeseRepository paeseoRepository;
	
	@Autowired
	PaeseMapper paeseMapper;

	@Override
	public Optional<PaeseDTO> findByNazione(String nazione) {
		logger.debug("Init findByNazione"); 
		Optional<PaeseDTO> OptionalPaeseDTO=Optional.empty();
		
		Optional<Paese> optionalPaese=paeseoRepository.findByIt(nazione);
		if(optionalPaese.isPresent()) {
			logger.debug("found By Nazione with name {}: {} is present", nazione, optionalPaese.get());
			
			OptionalPaeseDTO=Optional.of(paeseMapper.toDto(optionalPaese.get()));
		}
		
		return OptionalPaeseDTO;
	}
	
}
