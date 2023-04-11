package com.DataProject.DataJPA.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DataProject.DataJPA.domain.Aeroporto;
import com.DataProject.DataJPA.errors.ApplicationCode;
import com.DataProject.DataJPA.errors.JpaDataApiException;
import com.DataProject.DataJPA.service.AeroportoService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Aeroporto"})
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class AeroportoController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private AeroportoService aeroportoService;
	
	public AeroportoController(AeroportoService aeroportoService) {
		this.aeroportoService =aeroportoService;
	}
	@ApiOperation(value = "Restituisco l'Aeroporto attraverso l'Organizzazione Internazionale per l'Aviazione Civile ", response = Aeroporto.class)
	@ApiResponses(
	        value = {
	            @ApiResponse(code = 200, message = "Aeroporto by Icao"),
	            @ApiResponse(code = 401, message = "Not authorized"),
	            @ApiResponse(code = 404, message = "Aeroporto not found"),
	            @ApiResponse(code = 500, message = "Generic error")
	        }
	    )
	@GetMapping("/aeroporto/icao/{icao}") 
	public ResponseEntity<Aeroporto> getAeroportoIcao(@PathVariable String icao){
		logger.info("INIT Method getAeroportoIcao, param: {}", icao);
		
		Optional<Aeroporto> optionalAeroporto= aeroportoService.getAeroportoByIcao(icao);
		
		if(!optionalAeroporto.isPresent()) {
            logger.error("icao {} not found", icao);
            throw new JpaDataApiException(HttpStatus.NOT_FOUND, ApplicationCode.OBJECT_NOT_FOUND);
        }
		
		return new ResponseEntity<>(optionalAeroporto.get(), HttpStatus.OK);
	}
	@ApiOperation(value = "Restituisco tutti gli Aeroporto attraverso l'organizzazione internazionale delle compagnie aeree", response = Aeroporto.class)
	@ApiResponses(
	        value = {
	            @ApiResponse(code = 200, message = "Aeroporto by Iata"),
	            @ApiResponse(code = 401, message = "Not authorized"),
	            @ApiResponse(code = 404, message = "Aeroporto not found"),
	            @ApiResponse(code = 500, message = "Generic error")
	        }
	    )
	@GetMapping("/aeroporto/iata/{iata}") 
	public ResponseEntity<Aeroporto> getAeroportoIata(@PathVariable String iata){
		logger.info("INIT Method getAeroportoIata, param: {}", iata);
		
		Optional<Aeroporto> optionalAeroporto= aeroportoService.getAeroportoByIata(iata);	
		
		if(!optionalAeroporto.isPresent()) {
            logger.error("iata {} not found", iata);
            throw new JpaDataApiException(HttpStatus.NOT_FOUND, ApplicationCode.OBJECT_NOT_FOUND);
        }
		
		return new ResponseEntity<>(optionalAeroporto.get(), HttpStatus.OK);
	}
	@ApiOperation(value = "Restituisco tutti gli Aeroporto della Città inserita", response = Aeroporto.class)
	@ApiResponses(
	        value = {
	            @ApiResponse(code = 200, message = "Aeroporto by Citta"),
	            @ApiResponse(code = 401, message = "Not authorized"),
	            @ApiResponse(code = 404, message = "Aeroporto not found"),
	            @ApiResponse(code = 500, message = "Generic error")
	        }
	    )
	@GetMapping("/aeroporto/citta/{citta}") 
	public ResponseEntity<List<Aeroporto>> getAeroportoCitta(@PathVariable String citta){
		logger.info("INIT Method getAeroportoCitta, param: {}", citta);
		
		Optional<List<Aeroporto>> optionalAeroporto= aeroportoService.getAeroportoByCitta(citta);	
		
		if(!optionalAeroporto.isPresent()) {
            logger.error("iata {} not found", citta);
            throw new JpaDataApiException(HttpStatus.NOT_FOUND, ApplicationCode.OBJECT_NOT_FOUND);
        }

		return new ResponseEntity<>(optionalAeroporto.get(), HttpStatus.OK);
	}
}
