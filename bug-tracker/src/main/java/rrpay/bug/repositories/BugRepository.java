package rrpay.bug.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import rrpay.bug.entities.Bug;

public interface BugRepository extends MongoRepository<Bug,String> {

  public Bug deleteByCode(String code);

  public Bug findByCode(String code);
  
}
