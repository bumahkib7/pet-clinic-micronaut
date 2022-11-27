package com.example.service;

import com.example.models.Vet;

import java.util.Collection;
import java.util.Optional;

public interface VetService {


  Vet save(Vet vet) throws Exception;

  Collection<Vet> findAll() throws Exception;

  Optional<Vet> findOne(Long id) throws Exception;

  void delete(Long id) throws Exception;
}
