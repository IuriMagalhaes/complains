package com.fiap.hackathon.complains.repository;

import java.util.List;
import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.fiap.hackathon.complains.entity.Complains;

@EnableScan	
public interface ComplainsRepository extends CrudRepository<Complains, Long>{
	Optional<Complains> findById(String id);
	Optional<List<Complains>> findAllOptional();
}
