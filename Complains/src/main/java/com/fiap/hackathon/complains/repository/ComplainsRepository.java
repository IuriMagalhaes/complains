package com.fiap.hackathon.complains.repository;

import org.springframework.data.repository.CrudRepository;

import com.fiap.hackathon.complains.entity.Complains;

public interface ComplainsRepository extends CrudRepository<Complains, Long>{

}
