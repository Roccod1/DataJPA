package com.DataProject.DataJPA.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DataProject.DataJPA.domain.Paese;

@Repository
public interface PaeseRepository extends JpaRepository<Paese, String>{

	Optional<Paese> findByIt(String it);
}
