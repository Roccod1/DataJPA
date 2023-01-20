package com.DataProject.DataJPA.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DataProject.DataJPA.domain.ReceivedEmail;

@Repository
public interface ReceivedEmailRepository extends JpaRepository<ReceivedEmail, Integer> {

	@Query("select u from ReceivedEmail u where u.subject = :subject")
	Optional<List<ReceivedEmail>> findBySubject(String subject);
	
	@Transactional
	@Modifying
	@Query("UPDATE ReceivedEmail SET airline = :airline, status = :status WHERE id = :id")
	public void update(String airline, String status, int id);
	
//	@Query("select u from ReceivedEmail u where u.id = :id")
//	Optional<ReceivedEmail> findById(int id);
	
	
}
