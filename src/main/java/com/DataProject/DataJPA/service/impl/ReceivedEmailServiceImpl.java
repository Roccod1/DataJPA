package com.DataProject.DataJPA.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DataProject.DataJPA.domain.ReceivedEmail;
import com.DataProject.DataJPA.repository.ReceivedEmailRepository;
import com.DataProject.DataJPA.service.ReceivedEmailService;

@Service
public class ReceivedEmailServiceImpl implements ReceivedEmailService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	ReceivedEmailRepository receivedEmailRepository;
	
	@Override
	public Optional<List<ReceivedEmail>> cercaSubject(String subject) {
		logger.debug("Init cercaSubject");
		Optional<List<ReceivedEmail>> optionalReceivedEmail = receivedEmailRepository.findBySubject(subject);
		if(optionalReceivedEmail.isPresent()) {
			logger.debug("found cercaSubject with subject {}: {}", subject, optionalReceivedEmail.get());
		}
		return optionalReceivedEmail;
	}

//	@Override
	@Transactional
	public Optional<ReceivedEmail> salva(ReceivedEmail receivedEmail) {
		logger.debug("Init salva");
		ReceivedEmail response= receivedEmailRepository.saveAndFlush(receivedEmail);
		Optional<ReceivedEmail>optionalResponse=Optional.of(response);
		return optionalResponse;
	}

	@Override
	public Optional<ReceivedEmail> update(String airline, String status, Integer id) {
		logger.debug("Init Aggiorna");
//		ReceivedEmail receivedEmail = new ReceivedEmail();
//		receivedEmail.setId(id);
//		receivedEmail.setAirline(airline);
//		receivedEmail.setStatus(status);
//		receivedEmailRepository.saveAndFlush(receivedEmail);
		receivedEmailRepository.update(airline, status, id);		
		receivedEmailRepository.flush();
		Optional<ReceivedEmail>optionalReceivedEmail=receivedEmailRepository.findById(id);
		if(optionalReceivedEmail.isPresent()) {
			return optionalReceivedEmail;
		}
		return null;
	}

	@Override
	public Optional<ReceivedEmail> findById(Integer id) {
		Optional<ReceivedEmail>optionalById=Optional.empty();
		optionalById=receivedEmailRepository.findById(id);
		return optionalById;
	}

	@Override
	public Optional<ReceivedEmail> delete(Integer id) {
		logger.debug("Init cancella");
		Optional<ReceivedEmail>optionalById=Optional.empty();
		optionalById=receivedEmailRepository.findById(id);
		if(optionalById.isPresent()) {
			receivedEmailRepository.deleteById(id);	
		}
		return optionalById;
	}

}
