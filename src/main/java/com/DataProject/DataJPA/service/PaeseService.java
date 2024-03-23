package com.DataProject.DataJPA.service;


import java.util.Optional;
import com.DataProject.DataJPA.service.dto.PaeseDTO;

public interface PaeseService {
	
	Optional<PaeseDTO> findByNazione(String nazione);

}
