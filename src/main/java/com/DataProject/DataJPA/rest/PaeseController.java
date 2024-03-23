package com.DataProject.DataJPA.rest;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DataProject.DataJPA.errors.ApplicationCode;
import com.DataProject.DataJPA.errors.JpaDataApiException;
import com.DataProject.DataJPA.service.PaeseService;
import com.DataProject.DataJPA.service.dto.PaeseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Paese"}, description = "Operazioni relative alla ricerca in base al Paese")
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class PaeseController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	PaeseService paeseService;
	
	@ApiResponses(
	        value = {
	            @ApiResponse(code = 200, message = "Paese by Nazione"),
	            @ApiResponse(code = 401, message = "Not authorized"),
	            @ApiResponse(code = 404, message = "Paese not found"),
	            @ApiResponse(code = 500, message = "Generic error")
	        }
	    )
	@GetMapping("/paese/nomeItaliano/{nazione}") 
	public ResponseEntity<PaeseDTO> getPaeseByNazione(@PathVariable String nazione){
		logger.info("INIT Method getPaeseByNazione, param: {}", nazione);
		
		Optional<PaeseDTO> optionalPaeseDTO=paeseService.findByNazione(nazione);
		
		if(!optionalPaeseDTO.isPresent()) {
			logger.error("nazione {} not found", nazione);
			throw new JpaDataApiException(HttpStatus.NOT_FOUND, ApplicationCode.OBJECT_NOT_FOUND);
		}
		
		return new ResponseEntity<>(optionalPaeseDTO.get(), HttpStatus.OK);
	}

}
