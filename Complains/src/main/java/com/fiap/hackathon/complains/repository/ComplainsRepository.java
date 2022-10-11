package com.fiap.hackathon.complains.repository;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.fiap.hackathon.complains.model.entity.Complains;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface ComplainsRepository extends CrudRepository<Complains, String> {
    Optional<Complains> findById(String id);
}
