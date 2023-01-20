package com.DataProject.DataJPA.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DataProject.DataJPA.domain.ReceivedEmail;
import com.DataProject.DataJPA.errors.ApplicationCode;
import com.DataProject.DataJPA.errors.JpaDataApiException;
import com.DataProject.DataJPA.service.ReceivedEmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Received Email"})
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ReceivedEmailController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private final String subject="ANAGRAFICA_COMPAGNIA";
	
	@Autowired
	ReceivedEmailService receivedEmailService;
	
	@ApiResponses(
	        value = {
	            @ApiResponse(code = 200, message = "Email by subject"),
	            @ApiResponse(code = 401, message = "Not authorized"),
	            @ApiResponse(code = 404, message = "Email not found"),
	            @ApiResponse(code = 500, message = "Generic error")
	        }
	    )
	@GetMapping("/receivedEmail/subject") 
	public ResponseEntity<List<ReceivedEmail>> getCercaSubject(){
		
		logger.info("INIT Method getCercaSubject, param: {}", subject);
		
		Optional<List<ReceivedEmail>> optionalReceivedEmail= receivedEmailService.cercaSubject(subject);
		
		if(!optionalReceivedEmail.isPresent()) {
            logger.error("email {} not found", subject);
            throw new JpaDataApiException(HttpStatus.NOT_FOUND, ApplicationCode.OBJECT_NOT_FOUND);
        }
		
		return new ResponseEntity<>(optionalReceivedEmail.get(), HttpStatus.OK);
	}
	
	@ApiResponses(
	        value = {
	            @ApiResponse(code = 204, message = "Delete email by id"),
	            @ApiResponse(code = 401, message = "Not authorized"),
	            @ApiResponse(code = 404, message = "Email not found"),
	            @ApiResponse(code = 500, message = "Generic error")
	        }
	    )
	@DeleteMapping("/receivedEmail/cancella/{id}") 
	public ResponseEntity<ReceivedEmail> deleteEmail(Integer id){
		
		logger.info("INIT Method deleteEmail, param: {}", id);
		
		Optional<ReceivedEmail> optionalDelete=receivedEmailService.delete(id);
		
		if(!optionalDelete.isPresent()) {
			logger.error("email delete id{} not found", id);
            throw new JpaDataApiException(HttpStatus.NOT_FOUND, ApplicationCode.OBJECT_NOT_FOUND);
		}
		
		return new ResponseEntity<>(optionalDelete.get(), HttpStatus.NO_CONTENT);
	}
	@ApiResponses(
	        value = {
	            @ApiResponse(code = 200, message = "Update email by id, airline, status"),
	            @ApiResponse(code = 401, message = "Not authorized"),
	            @ApiResponse(code = 404, message = "Update not Possible"),
	            @ApiResponse(code = 500, message = "Generic error")
	        }
	    )
	@PutMapping("/receivedEmail/aggiorna/{id}/{airline}/{status}")
	public ResponseEntity<ReceivedEmail> aggiornamento(Integer id, String airline, String status){ 
		
		logger.info("INIT Method aggiungi, params: {id},{airline},{status}", id, airline, status);
		Optional<ReceivedEmail> optionalPut=receivedEmailService.findById(id);
		
		if(!optionalPut.isPresent()) {
			logger.error("email update id{} not found", id, airline, status);
            throw new JpaDataApiException(HttpStatus.NOT_FOUND, ApplicationCode.OBJECT_NOT_FOUND);
		}
		ReceivedEmail receivedById=optionalPut.get();
		optionalPut=Optional.empty();
		receivedById.setAirline(airline);
		receivedById.setStatus(status);
		optionalPut=receivedEmailService.salva(receivedById);
//		optionalPut=receivedEmailService.update(airline, status, id);
		if(optionalPut.isEmpty()) {
			logger.error("email update not found");
			throw new JpaDataApiException(HttpStatus.LOCKED, ApplicationCode.OBJECT_INVALID);
		}
		return new ResponseEntity<>(optionalPut.get(), HttpStatus.CREATED);
	}
	@ApiResponses(
	        value = {
	            @ApiResponse(code = 200, message = "Save email"),
	            @ApiResponse(code = 401, message = "Not authorized"),
	            @ApiResponse(code = 404, message = "Save not Possible"),
	            @ApiResponse(code = 500, message = "Generic error")
	        }
	    )
	@PostMapping("/receivedEmail/salva")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ReceivedEmail> salva(ReceivedEmail receivedEmail){
		logger.info("INIT Method salva params: ReceivedEmail");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:s");
//	    String str = formatter.format(date);
		receivedEmail.setCreatedDate(date);
		receivedEmail.setReceptionDate(date);
		receivedEmail.setLastModifiedDate(date);
		Optional<ReceivedEmail> optionalResponse=receivedEmailService.salva(receivedEmail);
		if(optionalResponse.isEmpty()) {
			logger.error("email Saving didn't work");
			throw new JpaDataApiException(HttpStatus.METHOD_NOT_ALLOWED, ApplicationCode.EMAIL_INVALID);
		}
		
		return new ResponseEntity<>(optionalResponse.get(), HttpStatus.OK);
	}
	
}
