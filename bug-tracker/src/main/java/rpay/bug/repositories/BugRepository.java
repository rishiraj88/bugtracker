package rpay.bug.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import rpay.bug.entities.Bug;

public interface BugRepository extends MongoRepository<Bug,String> {
  
}
