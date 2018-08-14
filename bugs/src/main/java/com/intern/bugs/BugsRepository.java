package com.intern.bugs;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

interface BugsRepository extends MongoRepository<BugsEntity, String> {

    void delete (BugsEntity deleted);

    List<BugsEntity> findAll();

    Optional<BugsEntity> findOne(String id);

    BugsEntity save(BugsEntity saved);
}