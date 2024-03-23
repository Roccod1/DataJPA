package com.DataProject.DataJPA.service;

import java.util.List;
import java.util.Optional;

import com.DataProject.DataJPA.domain.ReceivedEmail;

public interface ReceivedEmailService {
	
	Optional<List<ReceivedEmail>> cercaSubject(String subject);
	public Optional<ReceivedEmail> salva(ReceivedEmail receivedEmail);
	Optional<ReceivedEmail> update(String airline, String status, Integer id);
	Optional <ReceivedEmail> findById(Integer id);
	Optional<ReceivedEmail> delete(Integer id);

}
